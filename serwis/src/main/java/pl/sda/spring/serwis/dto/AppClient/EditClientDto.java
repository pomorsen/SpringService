package pl.sda.spring.serwis.dto.AppClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditClientDto {
    private String edit_name;
    private String edit_surname;
}