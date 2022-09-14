package com.lottyx.lottyxbackend.service;

import com.lottyx.lottyxbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AddressService {

    @Autowired
    private UserRepository userRepository;

}
