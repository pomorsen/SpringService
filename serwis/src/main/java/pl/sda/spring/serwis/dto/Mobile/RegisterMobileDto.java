package pl.sda.spring.serwis.dto.Mobile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.spring.serwis.model.AppClient;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterMobileDto {
    private String register_brand;
    private String register_model;
    private AppClient register_client;
}
