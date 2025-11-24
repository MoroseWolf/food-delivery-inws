package by.morwo.userservice.mapper;

import by.morwo.userservice.dto.UserCreateDTO;
import by.morwo.userservice.dto.UserDTO;
import by.morwo.userservice.dto.UserUpdateDTO;
import by.morwo.userservice.model.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {RoleMapper.class, AddressMapper.class}
)
public interface UserMapper {

    UserDTO toDTO(User user);

    List<UserDTO> toDTOList(List<User> users);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "roles", ignore = true)
        //@Mapping(target = "addresses", ignore = true)
    User toEntity(UserCreateDTO userCreateDTO);

    @Mapping(target = "roles", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDTO(UserUpdateDTO dto, @MappingTarget User user);

}
