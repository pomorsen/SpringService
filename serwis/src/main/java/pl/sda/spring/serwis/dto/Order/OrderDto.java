package pl.sda.spring.serwis.dto.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.spring.serwis.model.Order;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private long id;
    private String title, description;
    private LocalDateTime addTime;

    public static OrderDto createDto(Order order){
        return new OrderDto(
                order.getId(),
                order.getTitle(),
                order.getDescription(),
                order.getAddTime());
    }

}
