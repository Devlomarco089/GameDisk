package GDM.demo.services.devloper.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import GDM.demo.domain.Devloper;
import GDM.demo.mapper.devloper.DevloperMapper;
import GDM.demo.model.dto.devloper.DevloperDTO;
import GDM.demo.model.dto.game.GameDTO;
import GDM.demo.repository.devloper.DevloperRepository;
import GDM.demo.services.devloper.DevloperService;
import GDM.demo.services.game.GameService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DevloperServiceImpl implements DevloperService{

    private final DevloperMapper devloperMapper;
    private final GameService gameService;
    private final DevloperRepository devloperRepository;

    @Override
    public List<DevloperDTO> getGameDevlopers(String title) {
        GameDTO game = gameService.getGameByTitle(title);
        return game.getDevlopers();
    }

    @Override
    public Devloper createDevloper(DevloperDTO delvoper) {
        Devloper devloper = devloperMapper.devloperDtoToDevloper(delvoper);
        return devloperRepository.save(devloper);
    }

}
