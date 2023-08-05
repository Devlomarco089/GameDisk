package GDM.demo.model.dto.task;


import GDM.demo.enumeration.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDTO {
    private String description;
    private String limitDate;
    private StatusEnum status;
    private String idDevloper;
}
