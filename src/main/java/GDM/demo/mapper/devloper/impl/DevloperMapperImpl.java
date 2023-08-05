package GDM.demo.mapper.devloper.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import GDM.demo.domain.Devloper;
import GDM.demo.domain.Task;
import GDM.demo.mapper.devloper.DevloperMapper;
import GDM.demo.model.dto.devloper.DevloperDTO;



@Component
public class DevloperMapperImpl implements DevloperMapper{

    @Override
    public Devloper devloperDtoToDevloper(DevloperDTO devloper) {
        return Devloper.builder()
                .uuid(UUID.randomUUID())
                .name(devloper.getName())
                .email(devloper.getEmail())
                .rol(devloper.getRol())
                .build();
    }

    @Override
    public DevloperDTO devloperToDevloperDto(Devloper devloper) {
        DevloperDTO Devlo = DevloperDTO.builder()
                .name(devloper.getName())
                .email(devloper.getEmail())
                .rol(devloper.getRol())
                .build();

        if (!devloper.getTasks().isEmpty()){

            List<String> idTasks = new ArrayList<>();

            for (Task task:devloper.getTasks()){
                idTasks.add(task.getUuid().toString());
            }
        }
        return Devlo;
    }
    
}
