package pl.sda.spring.serwis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@Table(name = "service_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime addTime;

    public Order(String title, String description){
        this.title = title;
        this.description = description;
        this.addTime = LocalDateTime.now();
    }

}
