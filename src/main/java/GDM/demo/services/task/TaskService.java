package GDM.demo.services.task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import GDM.demo.domain.Task;
import GDM.demo.enumeration.StatusEnum;
import GDM.demo.model.dto.task.TaskDTO;

public interface TaskService {
    
    Task createTask(TaskDTO task);

    List<TaskDTO> getAllTask(String name);

    void updateStatusTask(UUID id, StatusEnum status);

    List<TaskDTO> getTaskByStatus(StatusEnum status);

    List<TaskDTO> getTaskDead(LocalDateTime localDateTime);

    List<TaskDTO> getTaskOfGame(String title);
}
