package pl.sda.spring.serwis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class AppClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String name, surname, address;

    public AppClient(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
