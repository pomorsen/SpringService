package pl.sda.spring.serwis.dto.AppClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterClientDto {
    private String register_email;
    private String register_password;
}
