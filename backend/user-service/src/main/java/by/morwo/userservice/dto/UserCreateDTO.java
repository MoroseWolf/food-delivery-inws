package by.morwo.userservice.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class UserCreateDTO {

    private String email;
    private String passwordHash;
    private String fullName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private List<AddressCreateDTO> addresses;
    private Set<String> roles;

    public UserCreateDTO(String email, String passwordHash, String fullName, LocalDateTime createdAt, LocalDateTime updatedAt, List<AddressCreateDTO> addresses, Set<String> roles) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.fullName = fullName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.addresses = addresses;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void getCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


    public List<AddressCreateDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressCreateDTO> addresses) {
        this.addresses = addresses;
    }
}
