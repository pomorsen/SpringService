package pl.sda.spring.serwis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.spring.serwis.dto.AppClient.AppClientDto;
import pl.sda.spring.serwis.dto.AppClient.EditClientDto;
import pl.sda.spring.serwis.dto.AppClient.RegisterClientDto;
import pl.sda.spring.serwis.dto.AppClient.UnregisterClientDto;
import pl.sda.spring.serwis.model.AppClient;
import pl.sda.spring.serwis.repository.AppClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppClientService {

    @Autowired
    private AppClientRepository appClientRepository;

    public Optional<AppClient> getClientData(Long id){
        return appClientRepository.findById(id);
    }

    public List<AppClientDto> getClientList() {
        List<AppClient> clients = appClientRepository.findAll();
        return clients.stream()
                .map(client -> AppClientDto.createDto(client))
                .collect(Collectors.toList());
    }

    public void registerClient(RegisterClientDto dto) {
        AppClient newClient = new AppClient(
                dto.getRegister_email(),
                dto.getRegister_password());
        appClientRepository.save(newClient);
    }

    public Optional<AppClient> unregister(Long id, UnregisterClientDto dto) {
        if (id != null) {
            Optional<AppClient> searchedClient = appClientRepository.findById(id);
            if (searchedClient.isPresent()) {
                AppClient client = searchedClient.get();
                if (client.getPassword().equals(dto.getUnregister_password()) &&
                        client.getEmail().equals(dto.getUnregister_email())) {
                    appClientRepository.delete(client);
                    return Optional.of(client);
                }
            }
        }
        return Optional.empty();
    }

    public Optional<AppClient> editClient(Long id, EditClientDto dto) {
        Optional<AppClient> serachedClient = appClientRepository.findById(id);
        if (serachedClient.isPresent()) {

            AppClient client = serachedClient.get();

            if (dto.getEdit_name() != null) {
                client.setName(dto.getEdit_name());
            }

            if(dto.getEdit_surname() != null){
                client.setSurname(dto.getEdit_surname());
            }

            if(dto.getEdit_address() != null){
                client.setAddress(dto.getEdit_address());
            }

            client = appClientRepository.save(client);

            return Optional.of(client);
        }
        return Optional.empty();
    }

}
