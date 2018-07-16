package pl.sda.spring.serwis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.spring.serwis.dto.Mobile.*;
import pl.sda.spring.serwis.model.AppClient;
import pl.sda.spring.serwis.model.Mobile;
import pl.sda.spring.serwis.service.AppClientService;
import pl.sda.spring.serwis.service.MobileService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/mobile")
public class MobileController {

    @Autowired
    private MobileService mobileService;

    @Autowired
    private AppClientService appClientService;

    @GetMapping("/list/{mobile_id}")
    public ResponseEntity<Mobile> getMobileData(@PathVariable(name = "mobile_id") Long id) {
        Optional<Mobile> searchedMobile = mobileService.getMobileData(id);
        if (searchedMobile.isPresent()) {
            return ResponseEntity.ok(searchedMobile.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<MobileDto>> listMobiles() {
        return ResponseEntity.ok(mobileService.getMobileList());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Mobile> editMobile(@PathVariable(name = "id") Long id, @RequestBody EditMobileDto dto) {
        Optional<Mobile> editedMobile = mobileService.editMobile(id, dto);
        if (editedMobile.isPresent()) {
            return ResponseEntity.ok(editedMobile.get());
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/client/{client_id}/addMobile")
    public ResponseEntity<AddedMobileDto> registerMobile(@PathVariable(name = "client_id") Long clientId, @RequestBody RegisterMobileDto dto) {
        Optional<AppClient> searchedClient = appClientService.getClientData(clientId);
        if(searchedClient.isPresent()){
            mobileService.registerMobile(clientId, dto);
            return ResponseEntity.ok(new AddedMobileDto(
                    dto.getRegister_brand(),
                    dto.getRegister_model(),
                    dto.getRegister_client().getId()
            ));
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/remove")
    public ResponseEntity<RemoveMobileDto> removeMobile(@RequestBody RemoveMobileDto dto) {
        Optional<Mobile> removeMobile = mobileService.removeMobile(dto.getRemove_id(), dto);
        if (removeMobile.isPresent()) {
            ResponseEntity.ok(new DeletedMobileDto(removeMobile.get()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}

