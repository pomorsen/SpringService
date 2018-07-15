package pl.sda.spring.serwis.dto.Mobile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.spring.serwis.model.Mobile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeletedMobileDto {
    private Mobile deletedMobile;
}
