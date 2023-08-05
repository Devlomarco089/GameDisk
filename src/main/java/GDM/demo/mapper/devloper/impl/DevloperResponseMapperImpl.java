package GDM.demo.mapper.devloper.impl;

import org.springframework.stereotype.Component;

import GDM.demo.domain.Devloper;
import GDM.demo.mapper.devloper.DevloperResponseMapper;
import GDM.demo.model.dto.devloper.DevloperResponseDTO;

@Component
public class DevloperResponseMapperImpl implements DevloperResponseMapper{

    @Override
    public DevloperResponseDTO devloperTODevloperResponseDTO(Devloper devloper) {
    
        return DevloperResponseDTO.builder()
                                    .name(devloper.getName())
                                    .email(devloper.getEmail())
                                    .rol(devloper.getRol())
                                    .build();
    }



}
