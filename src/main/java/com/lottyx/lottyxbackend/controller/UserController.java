package com.lottyx.lottyxbackend.controller;

import com.lottyx.lottyxbackend.model.User;
import com.lottyx.lottyxbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin( allowedHeaders = "*", origins = "*")
@RequestMapping("/api/v1/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController( UserService userService ) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findUser( @PathVariable("id") Long id ){
        User foundedUser = userService.getUser(id);
        return new ResponseEntity<>(foundedUser, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> removeUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/user")
    public User editUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @PostMapping("/user")
    public ResponseEntity<User> addNewUser(@RequestBody User user){
        User newUser = userService.postNewUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
}
