package com.ingJorgePertuz.foroHubAlura.repository;

import com.ingJorgePertuz.foroHubAlura.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Método para encontrar un usuario por su nombre de usuario
    Optional<User> findByUsername(String username);

    // Método para encontrar un usuario por su correo electrónico
    Optional<User> findByEmail(String email);
}



