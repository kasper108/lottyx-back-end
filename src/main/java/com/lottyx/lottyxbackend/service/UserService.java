package com.lottyx.lottyxbackend.service;

import com.lottyx.lottyxbackend.model.User;

import java.util.List;

public interface UserService {

    public User postNewUser( User user);
    public User getUserById(Long id);
    public List<User> getAllUsers();
    public User updateUser(User user);
    public void deleteUserById(Long id);
}
