package GDM.demo.model.dto.devloper;

import java.util.ArrayList;
import java.util.List;

import GDM.demo.enumeration.RolEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DevloperDTO {
    private String name;
    private String email;
    private RolEnum rol;
    @Builder.Default
    private List<String> idsTask = new ArrayList<>();
}
