package GDM.demo.services.task.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import GDM.demo.domain.Devloper;
import GDM.demo.domain.Game;
import GDM.demo.domain.Task;
import GDM.demo.enumeration.StatusEnum;
import GDM.demo.mapper.task.TaskMapper;
import GDM.demo.model.dto.task.TaskDTO;
import GDM.demo.repository.devloper.DevloperRepository;
import GDM.demo.repository.game.GameRepository;
import GDM.demo.repository.task.TaskRepository;
import GDM.demo.services.task.TaskService;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskMapper taskMapeer;
    private final DevloperRepository devloperRepository;
    private final TaskRepository taskRepository;
    private final GameRepository gameRepository;

    @Override
    public Task createTask(TaskDTO taskdto) {
        Task task = taskMapeer.taskDtoToTask(taskdto);
        UUID uuid = UUID.fromString(taskdto.getIdDevloper());
        Devloper devloper = devloperRepository.findByUuid(uuid);
        devloper.getTasks().add(task);
        return taskRepository.save(task);
    }

    @Override
    public List<TaskDTO> getAllTask(String name) {
        List<TaskDTO> taskList = new ArrayList<>();
        Devloper devloper = devloperRepository.findByNameEqualsIgnoreCase(name);
        for (Task task: devloper.getTasks()){
            taskList.add(taskMapeer.taskDtoToTask(task));
        }
        return taskList;
    }

    @Override
    public void updateStatusTask(UUID id, StatusEnum status) {
        Task task = taskRepository.findByuuid(id);
        task.setStatus(status);
    }

    @Override
    public List<TaskDTO> getTaskByStatus(StatusEnum status) {
        List<TaskDTO> taskdtoList = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();
        for (Task task:tasks){
            taskdtoList.add(taskMapeer.taskDtoToTask(task));
        }
        return taskdtoList;
    }

    @Override
    public List<TaskDTO> getTaskDead(LocalDateTime localDateTime) {
        List<Task> tasks =  taskRepository.findBylimitdateBefore(localDateTime);
        List<TaskDTO> tasklList = new ArrayList<>();
        for (Task task:tasks){
            tasklList.add(taskMapeer.taskDtoToTask(task));
        }
        return tasklList;
    }

    @Override
    public List<TaskDTO> getTaskOfGame(String title) {
        List<TaskDTO> taskList = new ArrayList<>();
        Game game = gameRepository.findBytitleEqualsIgnoreCase(title);
        List<Devloper> devlopers = game.getDevlopers();
        for (Devloper devloper:devlopers){
            for (Task task:devloper.getTasks()){
                taskList.add(taskMapeer.taskDtoToTask(task));
            }
        }
        return taskList;
    }
    
    
}
