package GDM.demo.mapper.game;


import GDM.demo.domain.Game;
import GDM.demo.model.dto.game.GameDTO;

public interface GameMapper {
    
    Game gameDtoToGame(GameDTO game);
    GameDTO gameToGameDto(Game game);
}
