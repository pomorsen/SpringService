package pl.sda.spring.serwis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private AppClient appClient;

    private String brand, model, os, cpu, memory;


    public Mobile(String brand, String model, Long appClientId ) {
        this.brand = brand;
        this.model = model;
        this.appClient.setId(appClientId);
    }


}
