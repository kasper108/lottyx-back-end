package com.lottyx.lottyxbackend.service;

import com.lottyx.lottyxbackend.exception.UserNotFoundException;
import com.lottyx.lottyxbackend.model.User;
import com.lottyx.lottyxbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException
                ("LOTTYX: User with ID = " + id + " NOT found in database"));
    }

    public User postNewUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(User user){
        User userFound = userRepository.findById(user.getId()).orElseThrow(() -> new UserNotFoundException
                ("LOTTYX: User with ID = " + user.getId() + " NOT found in database"));

        userFound.setName(user.getName());
        userFound.setSurname(user.getSurname());
        userFound.setEmail(user.getEmail());
        userFound.setPassword(user.getPassword());
        userFound.setDateCreated(user.getDateCreated());

        return userRepository.save(userFound);
    }
}
