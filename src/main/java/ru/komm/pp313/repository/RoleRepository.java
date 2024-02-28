package ru.komm.pp313.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.komm.pp313.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
