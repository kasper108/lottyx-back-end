package com.lottyx.lottyxbackend.service;

import com.lottyx.lottyxbackend.repository.AddressRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private AddressRepository addressRepository;
}
