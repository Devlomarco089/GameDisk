package GDM.demo.model.dto.devloper;

import java.util.ArrayList;
import java.util.List;

import GDM.demo.enumeration.RolEnum;
import GDM.demo.model.dto.task.TaskDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DevloperResponseDTO {
    
    private String name;
    private String email;
    private RolEnum rol;
    @Builder.Default
    private List<TaskDTO> TasksDTO = new ArrayList<>();
}
