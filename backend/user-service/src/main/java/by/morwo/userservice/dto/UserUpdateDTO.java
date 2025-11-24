package by.morwo.userservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

public class UserUpdateDTO {

    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String fullName;
    @Getter
    @Setter
    private Set<String> roles;
    @Getter
    @Setter
    private List<AddressCreateDTO> addresses;

}
