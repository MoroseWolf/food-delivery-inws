package by.morwo.userservice.mapper;

import by.morwo.userservice.dto.AddressCreateDTO;
import by.morwo.userservice.dto.AddressDTO;
import by.morwo.userservice.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface AddressMapper {

    AddressDTO toDTO(Address address);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Address toEntity(AddressCreateDTO dto);

    List<AddressDTO> toDTOList(List<Address> address);

}
