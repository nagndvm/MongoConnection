package com.example.mongoconnection.controller;

import com.example.mongoconnection.model.User;
import com.example.mongoconnection.model.UserSql;
import com.example.mongoconnection.repository.UserRepoMySql;
import com.example.mongoconnection.repository.UserRepository;
import com.example.mongoconnection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepoMySql userRepoMySql;

    @Autowired
    private UserService userService;


   /* @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OidcUser principal) {
        return principal.getClaims();
    }*/

    @PostMapping
    public User addUser(@RequestBody User user) {
        userService.sendMessage(user);
        UserSql userSql = new UserSql();
        userSql.setName(user.getName());
        userRepoMySql.save(userSql);
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userRepository.findByEmail(email);
    }

}
