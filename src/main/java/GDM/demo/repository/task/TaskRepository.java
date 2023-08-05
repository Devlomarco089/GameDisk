package GDM.demo.repository.task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import GDM.demo.domain.Task;
import GDM.demo.enumeration.StatusEnum;

public interface TaskRepository extends JpaRepository<Task, UUID>{
    Task findByuuid(UUID uuid);
    List<Task> findByStatus(StatusEnum status);

    List<Task> findBylimitdateBefore(LocalDateTime date);
}
