package org.example.ms_utilisateur.controller;

import org.example.ms_utilisateur.entity.User;
import org.example.ms_utilisateur.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>("Created !", HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("Deleted !", HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUs(@RequestBody User user, @PathVariable long id) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

}