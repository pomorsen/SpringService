package pl.sda.spring.serwis.dto.Mobile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.spring.serwis.model.Mobile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobileDto {
    private long id;
    private String brand, model, os, memory, cpu;

    public static MobileDto createDto(Mobile mobile){
        return new MobileDto(
                mobile.getId(),
                mobile.getBrand(),
                mobile.getModel(),
                mobile.getOs(),
                mobile.getMemory(),
                mobile.getCpu()
                );
    }

}
