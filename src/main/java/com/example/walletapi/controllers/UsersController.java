package com.example.walletapi.controllers;

import com.example.walletapi.mailers.UserMailer;
import com.example.walletapi.models.User;
import com.example.walletapi.services.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UsersController {
    private static Map<String, User> userRepo = new HashMap<>();
    private final UserInterface userInterface;

    @Autowired
    public UsersController(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    static {
        User ainun = new User();
        ainun.setId(1);
        ainun.setName("Ainun Jariya");
        userRepo.put(Integer.toString(ainun.getId()), ainun);
    }

    @GetMapping("/users")
    public ResponseEntity<Object> index() {
        return new ResponseEntity<>((List<User>) userInterface.findAll(), HttpStatus.OK);
//        return new ResponseEntity<>(userRepo.values(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") String id) {
        return new ResponseEntity<>(userRepo.get(id), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> create(@RequestBody User user) {
        userRepo.put(Integer.toString(user.getId()), user);
        UserMailer userMailer = new UserMailer();
        userMailer.sendMail();
        return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @RequestBody User user) {
        userRepo.remove(id);
        userRepo.put(id, user);
        UserMailer userMailer = new UserMailer();
        userMailer.sendMail();
        return new ResponseEntity<>("User is updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> destroy(@PathVariable("id") String id) {
        userRepo.remove(id);
        return new ResponseEntity<>("User is deleted successfully", HttpStatus.OK);
    }
}
