package pl.sda.spring.serwis.dto.AppClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.spring.serwis.model.AppClient;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedClientDto {
    private AppClient deletedClient;
}
