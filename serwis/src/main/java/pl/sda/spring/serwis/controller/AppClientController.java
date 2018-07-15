package pl.sda.spring.serwis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.spring.serwis.dto.AppClient.*;
import pl.sda.spring.serwis.model.AppClient;
import pl.sda.spring.serwis.service.AppClientService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/client")
public class AppClientController {

    @Autowired
    private AppClientService appClientService;

    /**
     * Show client's data
     * @param id
     * @return
     */
    @GetMapping("/list/{client_id}")
    public ResponseEntity<AppClient> getClientData(@PathVariable(name = "client_id") Long id){
        Optional<AppClient> searchedClient = appClientService.getClientData(id);
        if(searchedClient.isPresent()){
            return ResponseEntity.ok(searchedClient.get());
        }
        return ResponseEntity.badRequest().build();
    }

    /**
     * Show list of all client
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<AppClientDto>> listClients() {return ResponseEntity.ok(appClientService.getClientList());}

    /**
     * Edit chosen Client
     * @param id
     * @param dto
     * @return
     */
    @PostMapping("/edit/{id}")
    public ResponseEntity<AppClient> editClient(@PathVariable(name = "id") Long id, @RequestBody EditClientDto dto){
        Optional<AppClient> editedAppClient = appClientService.editClient(id,dto);
        if(editedAppClient.isPresent()){
            return ResponseEntity.ok(editedAppClient.get());
        }
        return ResponseEntity.badRequest().build();
    }

    /**
     * Register new client
     * @param dto
     */
    @PostMapping("/register")
    public void registerClient(@RequestBody RegisterClientDto dto){
        appClientService.registerClient(dto);
    }

    /**
     * Remove client from database
     * @param dto
     * @return
     */
    @DeleteMapping("/unregister")
    public ResponseEntity<UnregisterClientDto> removeClient(@RequestBody UnregisterClientDto dto){
        Optional<AppClient> removeClient = appClientService.unregister(dto.getUnregister_id(),dto);
        if(removeClient.isPresent()){
            ResponseEntity.ok(new DeletedClientDto(removeClient.get()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }





}
