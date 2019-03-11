package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class UserController
{
    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody  User user)
    {
        User savedUser=userService.saveUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public User GetUserById(@PathVariable int id)
    {
        Optional<User> savedUser=userService.findById(id);
        return  savedUser.get();

    }
    @DeleteMapping("/user/{id}")
    public void deleteStudent(@PathVariable int id) {
        userService.deleteById(id);
    }
    @PutMapping("/user/{id}")
    public String updateUser(@RequestBody User user, @PathVariable int id) {
        user.setId(id);
        userService.saveUser(user);
        return "update succesfully";
    }


    @GetMapping("/users")
    public ResponseEntity<List> getAllUsers()
    {
        return new ResponseEntity<List>(userService.getAlluser(),HttpStatus.OK);
    }
}
