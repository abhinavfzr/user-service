package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserServiceImpl
{

    public User saveUser(User user);
    public List<User> getAlluser();
    public Optional<User> findById(int id);
    User deleteById(int id);
}
