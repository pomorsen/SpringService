package pl.sda.spring.serwis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.spring.serwis.dto.Mobile.EditMobileDto;
import pl.sda.spring.serwis.dto.Mobile.MobileDto;
import pl.sda.spring.serwis.dto.Mobile.RegisterMobileDto;
import pl.sda.spring.serwis.dto.Mobile.RemoveMobileDto;
import pl.sda.spring.serwis.model.Mobile;
import pl.sda.spring.serwis.repository.MobileRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MobileService {

    @Autowired
    private MobileRepository mobileRepository;

    public Optional<Mobile> getMobileData(Long id) {
        return mobileRepository.findById(id);
    }

    public List<MobileDto> getMobileList(){
        List<Mobile> mobiles = mobileRepository.findAll();
        return mobiles.stream()
                .map(mobile -> MobileDto.createDto(mobile))
                .collect(Collectors.toList());
    }

    public void registerMobile(RegisterMobileDto dto) {
        Mobile newMobile = new Mobile(
                dto.getRegister_brand(),
                dto.getRegister_model(),
                dto.getRegister_user()
        );
        mobileRepository.save(newMobile);
    }

    public Optional<Mobile> removeMobile(Long id, RemoveMobileDto dto){
        if(id != null){
            Optional<Mobile> searchedMobile = mobileRepository.findById(id);
            if(searchedMobile.isPresent()){
                Mobile mobile = searchedMobile.get();
                if (mobile.getBrand().equals(dto.getRemove_brand()) && mobile.getModel().equals(dto.getRemove_model())){
                    mobileRepository.delete(mobile);
                    return Optional.of(mobile);
                }
            }
        }
        return Optional.empty();
    }

    public Optional<Mobile> editMobile(Long id, EditMobileDto dto){
        Optional<Mobile> searchedMobile = mobileRepository.findById(id);
        if(searchedMobile.isPresent()){

            Mobile mobile = searchedMobile.get();

            if(dto.getEdit_cpu() != null){
                mobile.setCpu(dto.getEdit_cpu());
            }

            if(dto.getEdit_memory() != null){
                mobile.setMemory(dto.getEdit_memory());
            }

            if(dto.getEdit_os() != null){
                mobile.setOs(dto.getEdit_os());
            }

            mobile = mobileRepository.save(mobile);

            return Optional.of(mobile);
        }
        return Optional.empty();
    }

}
