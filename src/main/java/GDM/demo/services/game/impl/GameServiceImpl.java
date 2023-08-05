package GDM.demo.services.game.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import GDM.demo.domain.Devloper;
import GDM.demo.domain.Game;
import GDM.demo.mapper.game.GameMapper;
import GDM.demo.model.dto.game.GameDTO;
import GDM.demo.repository.devloper.DevloperRepository;
import GDM.demo.repository.game.GameRepository;
import GDM.demo.services.game.GameService;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService{

    private final GameMapper gameMapper;
    private final GameRepository gameRepository;
    private final DevloperRepository devloperRepository;

    @Override
    public Game createGame(GameDTO gameDTO) {
        Game game = gameMapper.gameDtoToGame(gameDTO);
        return gameRepository.save(game);
    }

    @Override
    public List<GameDTO> getAllGames() {
        List<GameDTO> gameList = new ArrayList<>();
        for (Game game:gameRepository.findAll()){
            gameList.add(gameMapper.gameToGameDto(game));
        }
        return gameList;
    }

    @Override
    public List<GameDTO> getFinishedGames() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        List<Game> games =  gameRepository.findByrelasedateBefore(currentDateTime);
        List<GameDTO> finishedGames = new ArrayList<>();
        for (Game game:games){
            finishedGames.add(gameMapper.gameToGameDto(game));
        }
        return finishedGames;
    }

    @Override
    public GameDTO getGameByTitle(String title) {
        Game game = gameRepository.findBytitleEqualsIgnoreCase(title);
        return gameMapper.gameToGameDto(game);
    }

    @Override
    public Devloper addDevloperToGame(String name, String title) {
        Devloper devloper = devloperRepository.findByNameEqualsIgnoreCase(name);
        Game game = gameRepository.findBytitleEqualsIgnoreCase(title);
        game.getDevlopers().add(devloper);
        return devloper;
    }

}
