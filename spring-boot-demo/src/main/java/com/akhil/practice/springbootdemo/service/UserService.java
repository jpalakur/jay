package com.akhil.practice.springbootdemo.service;

import com.akhil.practice.springbootdemo.model.User;
import com.akhil.practice.springbootdemo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;
    public User saveUser(User user){
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public User findUser(long id){
        Optional<User> getUser = userRepository.findById(id);
        if(getUser.isPresent())
            return getUser.get();
        return null;
    }

    public List<User> getAllUsers(){
        List<User> userList = userRepository.findAll();
        return userList;
    }

    public void deleteUserAction(long id) {
        userRepository.deleteById(id);
    }
}
