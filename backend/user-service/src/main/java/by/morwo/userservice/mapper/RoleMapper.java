package by.morwo.userservice.mapper;

import by.morwo.userservice.dto.RoleDTO;
import by.morwo.userservice.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring"
)
public interface RoleMapper {
    RoleDTO toDTO(Role role);

    Role toEntity(RoleDTO roleDTO);

}
