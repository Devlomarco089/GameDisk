package GDM.demo.mapper.task;

import GDM.demo.domain.Task;
import GDM.demo.model.dto.task.TaskDTO;

public interface TaskMapper {
    
    Task taskDtoToTask(TaskDTO task);
    TaskDTO taskDtoToTask(Task task);
}
