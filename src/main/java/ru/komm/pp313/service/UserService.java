package ru.komm.pp313.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.komm.pp313.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<User> getAllUsers();
    public User getUser(int id);
    public void addUser(User user);
    public void editUser(int id, User user);
    public void deleteUser(int id);


}
