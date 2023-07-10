package com.starlingdiaz.TodoApp.service.impl;

import com.starlingdiaz.TodoApp.dto.LoginDto;
import com.starlingdiaz.TodoApp.dto.RegisterDto;
import com.starlingdiaz.TodoApp.entity.Role;
import com.starlingdiaz.TodoApp.entity.User;
import com.starlingdiaz.TodoApp.exception.TodoAPIException;
import com.starlingdiaz.TodoApp.repository.IUserRepository;
import com.starlingdiaz.TodoApp.repository.RoleRepository;
import com.starlingdiaz.TodoApp.service.IAuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private IUserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    @Override
    public String register(RegisterDto registerDto) {
        //check if user exists
        if (userRepository.existsByUsername(registerDto.getUsername())) {
         throw new TodoAPIException(HttpStatus.BAD_REQUEST,"Username already exists");
        }
        //check if email exists
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new TodoAPIException(HttpStatus.BAD_REQUEST,"Email already exists");
        }

        //create user
        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<Role>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        user.setRoles(roles);

        userRepository.save(user);


        return "User registered successfully";
    }

    @Override
    public String login(LoginDto loginDto) {
    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        loginDto.getUsernameOrEmail(),
                        loginDto.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "User logged in successfully";
    }
}
