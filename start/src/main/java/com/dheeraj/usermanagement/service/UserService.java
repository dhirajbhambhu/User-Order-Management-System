package com.dheeraj.usermanagement.service;
import com.dheeraj.usermanagement.dto.UserRequestDto;
import com.dheeraj.usermanagement.model.User;
import com.dheeraj.usermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.dheeraj.usermanagement.exception.UserNotFoundException;
import java.util.List;
import java.util.Optional;
import com.dheeraj.usermanagement.dto.UserResponseDto;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE USER
    public UserResponseDto addUser(UserRequestDto userRequestDto) {

        User user = new User();

        user.setName(userRequestDto.getName());
        user.setAge(userRequestDto.getAge());
        user.setCity(userRequestDto.getCity());

        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        User savedUser =  userRepository.save(user);
        return mapToResponseDto(savedUser);
    }

    // GET ALL USERS
    public List<UserResponseDto> getUsers() {

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }
    public UserResponseDto getUserById(int id){
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));
        return mapToResponseDto(user);
    }
    public UserResponseDto getUserByName(String name) {

        User user = userRepository.findByName(name)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));

        return mapToResponseDto(user);
    }
    public List<UserResponseDto> getUsersByCity(String city) {

        List<User> users = userRepository.findByCity(city);

        return users.stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }
    public List<UserResponseDto> getUsersOlderThan(int age) {

        List<User> users = userRepository.findByAgeGreaterThan(age);

        return users.stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    // UPDATE USER
    public String updateUser(int id, UserRequestDto updateUser) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {

            User existingUser = optionalUser.get();

            existingUser.setName(updateUser.getName());
            existingUser.setAge(updateUser.getAge());
            existingUser.setCity(updateUser.getCity());

            existingUser.setUpdatedAt(LocalDateTime.now());

            userRepository.save(existingUser);

            return "User updated successfully";
        }

        throw new UserNotFoundException("User not found");
    }
    

    // DELETE USER
    public String deleteUser(int id) {

        if (userRepository.existsById(id)) {

            userRepository.deleteById(id);

            return "User deleted successfully";
        }
        throw new UserNotFoundException("User not found");
    }
    private UserResponseDto mapToResponseDto(User user) {

        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getAge(),
                user.getCity(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
    public Page<UserResponseDto> getUsers(Pageable pageable) {

        Page<User> usersPage = userRepository.findAll(pageable);

        return usersPage.map(this::mapToResponseDto);
    }
}


