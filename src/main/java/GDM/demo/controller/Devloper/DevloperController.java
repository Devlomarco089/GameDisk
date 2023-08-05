package GDM.demo.controller.Devloper;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GDM.demo.domain.Devloper;
import GDM.demo.model.dto.devloper.DevloperDTO;
import GDM.demo.services.devloper.DevloperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/devloper")
@RequiredArgsConstructor
@Slf4j
public class DevloperController {
    private final DevloperService devloperService;


    @PostMapping()
    public ResponseEntity<Void> crateDevloper(@RequestBody DevloperDTO devloperDTO){
        log.info("Creacion de nuevo devloper");
        Devloper devloper = devloperService.createDevloper(devloperDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/devloper/"+ devloper.getUuid());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
        
    }

    @GetMapping("/{titleGame}")
    public List<DevloperDTO> getGameDevlopers(@PathVariable(value = "titleGame")String title){
        return devloperService.getGameDevlopers(title);
    }
}
