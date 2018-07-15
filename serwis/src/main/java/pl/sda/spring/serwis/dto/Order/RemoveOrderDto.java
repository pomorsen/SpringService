package pl.sda.spring.serwis.dto.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemoveOrderDto {
    private Long remove_id;
    private String remove_title;
    private String remove_description;
}
