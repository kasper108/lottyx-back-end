package com.lottyx.lottyxbackend.service;

import com.lottyx.lottyxbackend.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AddressService {


    private AddressRepository addressRepository;

    @Autowired
    public AddressService( AddressRepository addressRepository ) {
        this.addressRepository = addressRepository;
    }
}
