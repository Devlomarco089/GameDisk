package GDM.demo.repository.devloper;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import GDM.demo.domain.Devloper;

public interface DevloperRepository extends JpaRepository<Devloper, UUID>{
    Devloper findByNameEqualsIgnoreCase(String name);
    Devloper findByUuid(UUID uuid);
}
