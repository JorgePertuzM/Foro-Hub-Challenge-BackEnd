package com.ingJorgePertuz.foroHubAlura.service;

import com.ingJorgePertuz.foroHubAlura.model.User;
import com.ingJorgePertuz.foroHubAlura.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Crear un nuevo usuario
    public User createUser(User user) {
        // Verificar si el nombre de usuario ya existe
        Optional<User> existingUserByUsername = userRepository.findByUsername(user.getUsername());
        if (existingUserByUsername.isPresent()) {
            throw new IllegalArgumentException("El nombre de usuario ya está en uso.");
        }

        // Verificar si el correo electrónico ya existe
        Optional<User> existingUserByEmail = userRepository.findByEmail(user.getEmail());
        if (existingUserByEmail.isPresent()) {
            throw new IllegalArgumentException("El correo electrónico ya está en uso.");
        }

        try {
            // Si no existe, guardar el nuevo usuario
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            // Excepción en caso de errores de integridad (como duplicados)
            throw new IllegalArgumentException("Error al guardar el usuario. Verifique los datos.");
        }
    }

    // Actualizar un usuario existente
    public Optional<User> updateUser(Long id, User user) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        });
    }

    // Eliminar un usuario existente
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
