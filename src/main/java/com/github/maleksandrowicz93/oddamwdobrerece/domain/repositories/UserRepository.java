package com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByRole(String role);
    List<User> findAllByRoleNot(String roleNot);
    User findFirstById(Long id);
    Optional<User> findByUsername(String username);

}
