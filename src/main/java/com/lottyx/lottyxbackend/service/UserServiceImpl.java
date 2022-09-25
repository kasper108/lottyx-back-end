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
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    @Override
    public User postNewUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException
                ("LOTTYX: User with ID = " + id + " NOT found in database"));
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    @Override
    public User updateUser(User user){
        User userFound = userRepository.findById(user.getId()).orElseThrow(() -> new UserNotFoundException
                ("LOTTYX: User with ID = " + user.getId() + " NOT found in database"));

        userFound.setName(user.getName());
        userFound.setSurname(user.getSurname());
        userFound.setEmail(user.getEmail());
        userFound.setPassword(user.getPassword());
        //userFound.setDateCreated(user.getDateCreated());

        return userRepository.save(userFound);
    }

    @Override
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

}
