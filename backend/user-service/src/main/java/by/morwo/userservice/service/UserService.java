package by.morwo.userservice.service;

import by.morwo.userservice.dto.AddressCreateDTO;
import by.morwo.userservice.dto.UserCreateDTO;
import by.morwo.userservice.dto.UserDTO;
import by.morwo.userservice.dto.UserUpdateDTO;
import by.morwo.userservice.mapper.AddressMapper;
import by.morwo.userservice.mapper.UserMapper;
import by.morwo.userservice.model.Address;
import by.morwo.userservice.model.Role;
import by.morwo.userservice.repository.AddressRepository;
import by.morwo.userservice.repository.RoleRepository;
import by.morwo.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AddressRepository addressRepository;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;


    public List<UserDTO> getAllUsers() {
        return userMapper.toDTOList(userRepository.findAll());
    }

    public UserDTO getUserById(long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + id));
    }

    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        var user = userMapper.toEntity(userCreateDTO);
        user.setPasswordHash("EXAMPLE PASSWORD" + userCreateDTO.getPasswordHash());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        if (userCreateDTO.getRoles() != null && !userCreateDTO.getRoles().isEmpty()) {
            var roles = roleRepository.findAllByNameIn(userCreateDTO.getRoles());
            if (roles.isEmpty()) {
                throw new IllegalArgumentException("Roles not found: " + userCreateDTO.getRoles());
            }
            user.getRoles().addAll(roles);
        }

        if (userCreateDTO.getAddresses() != null && !userCreateDTO.getAddresses().isEmpty()) {
            for (AddressCreateDTO addCrDTO : userCreateDTO.getAddresses()) {
                Address address = addressMapper.toEntity(addCrDTO);
                address.setUser(user);
                user.getAddresses().add(address);
            }
        }

        return userMapper.toDTO(userRepository.save(user));
    }

    public UserDTO updateUser(Long id, UserUpdateDTO usUpDTO) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + id));

        if (usUpDTO.getEmail() != null && !usUpDTO.getEmail().equals(user.getEmail())) {
            if (userRepository.existsByEmail(usUpDTO.getEmail())) {
                throw new IllegalArgumentException("Email already exists: " + usUpDTO.getEmail());
            }
            user.setEmail(usUpDTO.getEmail());
        }

        if (usUpDTO.getFullName() != null) {
            user.setFullName(usUpDTO.getFullName());
        }

        if (usUpDTO.getRoles() != null) {
            user.getRoles().clear();
            if (!usUpDTO.getRoles().isEmpty()) {
                Set<Role> roles = roleRepository.findAllByNameIn(usUpDTO.getRoles());
                user.getRoles().addAll(roles);
            }
        }

        if (usUpDTO.getAddresses() != null) {
            user.getAddresses().clear();
            for (AddressCreateDTO addrDto : usUpDTO.getAddresses()) {
                Address address = addressMapper.toEntity(addrDto);
                address.setUser(user);
                user.addAddress(address);
            }
        }

        user.setUpdatedAt(LocalDateTime.now());
        return userMapper.toDTO(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + id));
        userRepository.delete(user);
    }
}

