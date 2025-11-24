package by.morwo.userservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RoleDTO {
    @Setter
    @Getter
    private Long id;
    @Setter
    @Getter
    private String name;

    public RoleDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
