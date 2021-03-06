package com.github.maleksandrowicz93.oddamwdobrerece.services;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Gift;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.UserRepository;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public void registerUser(UserDTO newUser) {
        User user = UserConverter.userDtoToUser(newUser);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        logger.info("rejestracja użytkownika " + user);
        userRepository.save(user);
        logger.info("Zarejestrowany użytkownik: " + user);
    }

    public User findById(Long id) {
        return userRepository.findFirstById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findFirstByUsername(username);
    }

    public List<User> findAllAdmins() {
        return userRepository.findAllByRole("ADMIN");
    }

    public List<User> findAllUsers() {
        return userRepository.findAllByRoleNot("ADMIN");
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.deleteById(user.getId());
    }

    private UserDTO findUserAndConvertToUserDTO(String username) {
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
        return UserConverter.userToUserDto(user);
    }

    public void assignGiftToUser(User user, Gift gift) {
        List<Gift> gifts = user.getGifts();
        gifts.add(gift);
        user.setGifts(gifts);
        userRepository.save(user);
    }

    public boolean checkPasswordEquality(UserDTO newUser) {
        return newUser.getPassword().equals(newUser.getConfirmedPassword());
    }

    public boolean checkIsUserNameAvailable(UserDTO newUser) {
        UserDTO user = findUserAndConvertToUserDTO(newUser.getUsername());
        return user == null;
    }

    public void saveUserChanges(UserDTO userDTO, User user) {
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        if (!userDTO.getPassword().equals("")) {
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }
    }
}
