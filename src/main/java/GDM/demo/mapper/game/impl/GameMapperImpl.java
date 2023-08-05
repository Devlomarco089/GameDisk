package GDM.demo.mapper.game.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import GDM.demo.domain.Game;
import GDM.demo.mapper.game.GameMapper;
import GDM.demo.model.dto.game.GameDTO;

@Component
public class GameMapperImpl implements GameMapper{

    @Override
    public Game gameDtoToGame(GameDTO game) {
        return Game.builder()
                .uuid(UUID.randomUUID())
                .title(game.getTitle())
                .relasedate(getLocalDateTime(game.getRelasedate()))
                .description(game.getDescription())
                .build();
    }

    @Override
    public GameDTO gameToGameDto(Game game) {
        return GameDTO.builder()
                .title(game.getTitle())
                .relasedate(getLocalDateTime(game.getRelasedate()))
                .description(game.getDescription())
                .build();
    }
    
    private LocalDateTime getLocalDateTime(String date){
        if (!date.isBlank()){
            String[] parts = date.split("/");
            return LocalDateTime.of(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),0,0);
        }
        return null;
    }
    private String getLocalDateTime(LocalDateTime localDateTime){
        StringBuffer stringBuffer = new StringBuffer();
        return stringBuffer.append(localDateTime.getYear())
                .append("/")
                .append(localDateTime.getMonthValue())
                .append("/")
                .append(localDateTime.getDayOfYear())
                .toString();
    }
}
