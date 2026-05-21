package com.dheeraj.usermanagement.service;

import com.dheeraj.usermanagement.model.User;
import com.dheeraj.usermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE USER
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // GET ALL USERS
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // UPDATE USER
    public String updateUser(int id, User updateUser) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {

            User existingUser = optionalUser.get();

            existingUser.setName(updateUser.getName());
            existingUser.setAge(updateUser.getAge());
            existingUser.setCity(updateUser.getCity());

            userRepository.save(existingUser);

            return "User updated successfully";
        }

        return "User not found";
    }

    // DELETE USER
    public String deleteUser(int id) {

        if (userRepository.existsById(id)) {

            userRepository.deleteById(id);

            return "User deleted successfully";
        }

        return "User not found";
    }
}


