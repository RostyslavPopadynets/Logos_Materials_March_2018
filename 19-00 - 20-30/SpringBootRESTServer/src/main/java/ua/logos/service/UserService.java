package ua.logos.service;

import ua.logos.entity.User;
import java.util.List;


public interface UserService {

    User save(User user);
    User findById(Long id);
    List<User> findAll();
    void delete(String username);
    User findByUsername(String username);
    boolean existsByUsername(String username);
    String signup(User user);
    String signin(String username, String password);
}
