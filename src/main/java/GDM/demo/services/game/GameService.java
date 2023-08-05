package GDM.demo.services.game;

import java.util.List;

import GDM.demo.domain.Devloper;
import GDM.demo.domain.Game;
import GDM.demo.model.dto.game.GameDTO;

public interface GameService {
    
    Game createGame(GameDTO gameDTO);

    List<GameDTO> getAllGames();

    List<GameDTO> getFinishedGames();

    GameDTO getGameByTitle(String title);

    Devloper addDevloperToGame(String name,String title);
}
