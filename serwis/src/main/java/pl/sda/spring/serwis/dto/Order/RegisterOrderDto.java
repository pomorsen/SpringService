package pl.sda.spring.serwis.dto.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterOrderDto {
    private String register_title;
    private String register_description;
}
