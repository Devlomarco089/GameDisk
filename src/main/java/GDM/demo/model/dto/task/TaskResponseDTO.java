package GDM.demo.model.dto.task;

import GDM.demo.enumeration.StatusEnum;
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
public class TaskResponseDTO {

    private String id;
    private String limitDate;
    private StatusEnum status;
    private String description;
}
