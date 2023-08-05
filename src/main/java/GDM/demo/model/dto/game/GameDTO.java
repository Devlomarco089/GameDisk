package GDM.demo.model.dto.game;

import java.util.List;

import GDM.demo.model.dto.devloper.DevloperDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameDTO {
    
    private String title;
    private String relasedate;
    private String description;
    private List<DevloperDTO> devlopers;
}
