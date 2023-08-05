package GDM.demo.controller.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import GDM.demo.domain.Task;
import GDM.demo.enumeration.StatusEnum;
import GDM.demo.model.dto.task.TaskDTO;
import GDM.demo.services.task.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/task")
@Slf4j
@RequiredArgsConstructor
public class TaskController {
    
    private final TaskService taskService;

    @PostMapping()
    public ResponseEntity<Void> createTask(@RequestBody TaskDTO taskDTO){
        log.info("Creando tarea");
        Task task = taskService.createTask(taskDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/task/"+ task.getUuid());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
        
    }

    @GetMapping("/{namedevloper}")
    public List<TaskDTO> getAllTaskFromDevloper(@PathVariable(value = "namedevloper")String name){
        return taskService.getAllTask(name);
    }

    @PostMapping("/tasks/{id}/status")
    public void updateTaskStatus(@PathVariable UUID id, @RequestBody StatusEnum status) {
        taskService.updateStatusTask(id, status);
    }

    @GetMapping("/tasks")
    public List<TaskDTO> getTasksByStatus(@RequestParam StatusEnum status) {
        return taskService.getTaskByStatus(status);
    }

    @GetMapping("/tasks/deadline")
    public List<TaskDTO> getTasksBeforeDeadline(@RequestParam(required = false) LocalDateTime localDateTime) {
        if (localDateTime == null) {
            localDateTime = LocalDateTime.now();
        }
        return taskService.getTaskDead(localDateTime);
    }

    @GetMapping("/tasks/game/{title}")
    public List<TaskDTO> getTasksOfGame(@PathVariable String title) {
        return taskService.getTaskOfGame(title);
    }
}
