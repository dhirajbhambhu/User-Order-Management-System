package com.dheeraj.usermanagement.service;
import com.dheeraj.usermanagement.dto.LoginRequestDto;
import com.dheeraj.usermanagement.dto.LoginResponseDto;
import com.dheeraj.usermanagement.dto.RegisterRequestDto;
import com.dheeraj.usermanagement.dto.RegisterResponseDto;
import com.dheeraj.usermanagement.model.User;
import com.dheeraj.usermanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public RegisterResponseDto register(RegisterRequestDto requestDto) {

        User user = new User();

        user.setName(requestDto.getName());
        user.setAge(requestDto.getAge());
        user.setCity(requestDto.getCity());
        user.setEmail(requestDto.getEmail());
        user.setPassword(
                passwordEncoder.encode(requestDto.getPassword())
        );

        User savedUser = userRepository.save(user);

        return new RegisterResponseDto(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }
    public LoginResponseDto login(LoginRequestDto requestDto) {

        User user = userRepository.findByEmail(requestDto.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid Email or Password"));

        boolean matches =
                passwordEncoder.matches(
                        requestDto.getPassword(),
                        user.getPassword()
                );
        System.out.println("Entered Password = " + requestDto.getPassword());
        System.out.println("Database Password = " + user.getPassword());

        boolean matches1= passwordEncoder.matches(
                requestDto.getPassword(),
                user.getPassword()
        );

        System.out.println("Matches = " + matches);

        if (!matches) {
            throw new RuntimeException("Invalid Email or Password");
        }

        return new LoginResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
