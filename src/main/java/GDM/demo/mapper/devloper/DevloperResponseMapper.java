package GDM.demo.mapper.devloper;

import GDM.demo.domain.Devloper;
import GDM.demo.model.dto.devloper.DevloperResponseDTO;

public interface DevloperResponseMapper {
    
    DevloperResponseDTO devloperTODevloperResponseDTO(Devloper devloper);
}
