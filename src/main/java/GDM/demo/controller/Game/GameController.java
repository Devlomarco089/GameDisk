package GDM.demo.controller.Game;


import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import GDM.demo.domain.Devloper;
import GDM.demo.domain.Game;
import GDM.demo.model.dto.game.GameDTO;
import GDM.demo.services.game.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/game")
@Slf4j
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping()
    public ResponseEntity<Void> createGame(@RequestBody GameDTO gameDTO){
        log.info("Creacion del juego");
        Game game = gameService.createGame(gameDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Locatio", "/api/v1/game/" + game.getUuid());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/allgames")
    public List<GameDTO> getAllGames(){
        return gameService.getAllGames();
    }

    @GetMapping("/finishedgames")
    public List<GameDTO> finishedGames(){
        return gameService.getFinishedGames();
    }

    @GetMapping("/{titlegame}")
    public GameDTO getGameByTitle(@PathVariable(value = "titlegame")String title){
        return gameService.getGameByTitle(title);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addDevloperToGame(@RequestParam String name, @RequestParam String title){
        log.info("Agregando Desarrollador");
        Devloper devloper = gameService.addDevloperToGame(name, title);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Locatio", "/api/v1/game/add/" + devloper.getUuid());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
