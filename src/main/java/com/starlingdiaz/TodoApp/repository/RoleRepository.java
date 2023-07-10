package com.starlingdiaz.TodoApp.repository;

import com.starlingdiaz.TodoApp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

}
