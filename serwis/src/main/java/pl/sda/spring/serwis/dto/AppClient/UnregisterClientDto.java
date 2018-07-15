package pl.sda.spring.serwis.dto.AppClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.spring.serwis.model.AppClient;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnregisterClientDto {
    private Long unregister_id;
    private String unregister_email;
    private String unregister_password;
}
