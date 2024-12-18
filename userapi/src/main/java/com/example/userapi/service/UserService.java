package com.example.userapi.service;
import com.example.userapi.exception.UserAlreadyExistsException;
import com.example.userapi.dto.UserDTO;
import com.example.userapi.exception.UserNotFoundException;
import com.example.userapi.model.User;
import com.example.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(UserDTO userDTO){
        if (userRepository.existsByEmail(userDTO.getEmail())){
            throw new UserAlreadyExistsException("El email ya está registrado");
        }
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return userRepository.save(user);


    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(Long id, UserDTO userDTO){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        if (!userRepository.existsById(id)){
            throw new UserNotFoundException("Usuario no encontrado");
        }
        userRepository.deleteById(id);
    }

}

