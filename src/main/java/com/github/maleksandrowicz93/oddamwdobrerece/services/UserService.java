package com.github.maleksandrowicz93.oddamwdobrerece.services;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.UserRepository;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void updateUser(UserDTO userDTO, User user) {
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
    }

    @Transactional
    public void registerUser(UserDTO newUser) {
        User user = Converters.userDtoToUser(newUser);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        logger.info("rejestracja użytkownika " + user);
        userRepository.save(user);
        logger.info("Zarejestrowany użytkownik: " + user);
    }

    public UserDTO findUser(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Nazwa użytkownika musi być podana");
        }
        Optional<User> optionalUser = userRepository.findByUsername(username);
        User user = optionalUser.orElse(null);
        if (user == null) {
            logger.debug("Nie znaleziono użytkownika dla nazwy '" + username + "'");
            return null;
        }
        logger.debug("Znaleziono użytkownika dla nazwy '" + username + "' : " + user);
        return Converters.userToUserDto(user);
    }

}
