package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserFileSystemService implements UserServiceImpl
{
    private UserRepository userRepository;

    @Autowired
    public UserFileSystemService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user)
    {
        User saveUser= userRepository.save(user);
        return saveUser;
    }

    @Override
    public List<User> getAlluser() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        Optional<User> saveUser= userRepository.findById(id);
        return saveUser;
    }

    @Override
    public User deleteById(int id) {
        userRepository.deleteById(id);
        return null;
    }

}
