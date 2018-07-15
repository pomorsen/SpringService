package pl.sda.spring.serwis.dto.Mobile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditMobileDto {
    private String edit_cpu;
    private String edit_memory;
    private String edit_os;
}
