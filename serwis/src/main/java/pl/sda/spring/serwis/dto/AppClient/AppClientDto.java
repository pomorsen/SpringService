package pl.sda.spring.serwis.dto.AppClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.spring.serwis.model.AppClient;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppClientDto {
    private long id;
    private String email, name, surname, address;

    public static AppClientDto createDto(AppClient client){
        return new AppClientDto(
                client.getId(),
                client.getEmail(),
                client.getName(),
                client.getSurname(),
                client.getAddress());
    }
}
