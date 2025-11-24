package by.morwo.userservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDTO {

    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    private String email;

    @Setter
    @Getter
    private String passwordHash;

    @Setter
    @Getter
    private String fullName;

    @Setter
    @Getter
    private LocalDateTime createdAt;

    @Setter
    @Getter
    private LocalDateTime updatedAt;

    @Setter
    @Getter
    private List<AddressDTO> addresses;

    @Setter
    @Getter
    private Set<RoleDTO> roles = new HashSet<>();

}
