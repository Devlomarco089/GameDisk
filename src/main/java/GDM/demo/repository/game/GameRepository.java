package GDM.demo.repository.game;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import GDM.demo.domain.Game;

public interface GameRepository extends JpaRepository<Game, UUID>{
    List<Game> findByrelasedateBefore(LocalDateTime currentDateTime);
    Game findBytitleEqualsIgnoreCase(String title);
}
