package pl.sda.spring.serwis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.spring.serwis.model.AppClient;

@Repository
public interface AppClientRepository extends JpaRepository<AppClient, Long> {
}

