package GDM.demo.mapper.task.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import GDM.demo.domain.Task;
import GDM.demo.mapper.task.TaskMapper;
import GDM.demo.model.dto.task.TaskDTO;

@Component
public class TaskMapperImpl implements TaskMapper{

    @Override
    public Task taskDtoToTask(TaskDTO task) {
        return Task.builder()
                    .uuid(UUID.randomUUID())
                    .description(task.getDescription())
                    .limitdate(getLocalDateTime(task.getLimitDate()))
                    .status(task.getStatus())
                    .build();

    }

    @Override
    public TaskDTO taskDtoToTask(Task task) {
        return TaskDTO.builder()
                    .description(task.getDescription())
                    .limitDate(getLocalDateTime(task.getLimitdate()))
                    .status(task.getStatus())
                    .build();
    }

    private LocalDateTime getLocalDateTime(String date){
        if (!date.isBlank()){
            String[] parts = date.split("/");
            return LocalDateTime.of(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),0,0);
        }
        return null;
    }
    private String getLocalDateTime(LocalDateTime localDateTime){
        StringBuffer stringBuffer = new StringBuffer();
        return stringBuffer.append(localDateTime.getYear())
                .append("/")
                .append(localDateTime.getMonthValue())
                .append("/")
                .append(localDateTime.getDayOfYear())
                .toString();
    }
}
