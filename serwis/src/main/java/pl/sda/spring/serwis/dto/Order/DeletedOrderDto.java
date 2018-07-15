package pl.sda.spring.serwis.dto.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.spring.serwis.model.Order;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedOrderDto {
    private Order deletedOrder;
}