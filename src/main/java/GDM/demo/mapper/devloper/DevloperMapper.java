package GDM.demo.mapper.devloper;

import GDM.demo.domain.Devloper;
import GDM.demo.model.dto.devloper.DevloperDTO;

public interface DevloperMapper {
    
    Devloper devloperDtoToDevloper(DevloperDTO devloper);
    DevloperDTO devloperToDevloperDto(Devloper devloper);

}
