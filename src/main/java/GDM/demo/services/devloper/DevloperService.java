package GDM.demo.services.devloper;

import java.util.List;

import GDM.demo.domain.Devloper;
import GDM.demo.model.dto.devloper.DevloperDTO;

public interface DevloperService {

    List<DevloperDTO> getGameDevlopers(String title);

    Devloper createDevloper(DevloperDTO delvoper);

}
