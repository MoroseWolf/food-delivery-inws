package by.morwo.userservice.repository;

import by.morwo.userservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Set<Role> findAllByNameIn(Set<String> names);

    Optional<Role> findOneByName(String name);
}
