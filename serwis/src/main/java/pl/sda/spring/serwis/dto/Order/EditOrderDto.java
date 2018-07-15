package pl.sda.spring.serwis.dto.Order;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditOrderDto {
    private String edit_description;
}
