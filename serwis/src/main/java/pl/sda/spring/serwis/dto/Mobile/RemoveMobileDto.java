package pl.sda.spring.serwis.dto.Mobile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemoveMobileDto {
    private Long remove_id;
    private String remove_brand;
    private String remove_model;
}
