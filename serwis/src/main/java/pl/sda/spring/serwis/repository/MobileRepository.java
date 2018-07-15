package pl.sda.spring.serwis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.spring.serwis.model.Mobile;

@Repository
public interface MobileRepository extends JpaRepository<Mobile,Long> {
}
