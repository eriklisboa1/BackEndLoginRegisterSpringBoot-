package com.example.demo.Service;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.PasswordUtils;
import com.example.demo.model.RegistrationRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(RegistrationRequest request) {
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new RuntimeException("As senhas não são iguais");
        }
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        // Utiliza o PasswordUtils para criptografar a senha
        user.setPassword(PasswordUtils.hashPassword(request.getPassword()));
        return userRepository.save(user);
    }

    public User loginUser(LoginRequest request) {
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
        if (userOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }
        User user = userOptional.get();
        // Verifica a senha utilizando o PasswordUtils
        if (!PasswordUtils.checkPassword(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Senha incorreta");
        }
        return user;
    }
}
