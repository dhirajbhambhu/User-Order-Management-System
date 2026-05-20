package com.dheeraj.usermanagement.service;

import com.dheeraj.usermanagement.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    List<User> users = new ArrayList<>();
    int nextId = 1;

    public User addUser(User user) {
        if(user.getName()==null||user.getName().isEmpty()){
            return null;
        }
        if(user.getAge()<0){
            return null;
        }
        user.setId(nextId);
        nextId++;
        users.add(user);
        return user;
    }

    public List<User> getUsers() {
        return users;
    }

    public User updateUser(int id, User updateUser) {
        for (User user : users) {
            if (user.getId() == id) {
                user.setName(updateUser.getName());
                user.setAge(updateUser.getAge());
                user.setCity(updateUser.getCity());
                return user;
            }
        }
        return null;
    }

    public String deleteUser(int id) {
        boolean removed = users.removeIf(user -> user.getId() == id);
        if (removed) {
            return "User deleted successfully";
        }
        return "User not found";
    }
}



