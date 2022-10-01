package com.lottyx.lottyxbackend.controller;

import com.lottyx.lottyxbackend.model.Address;
import com.lottyx.lottyxbackend.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin( allowedHeaders = "*", origins = "*")
@RequestMapping("api/v1/")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController( AddressService addressService ) {
        this.addressService = addressService;
    }

    @PostMapping("/address")
    public ResponseEntity<Address> addNewAddress( @RequestBody Address address ){
        Address newAddress = addressService.postNewAddress(address);
        return new ResponseEntity<>(newAddress, HttpStatus.CREATED);
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> findAddress(@PathVariable("id") Long id){
        Address foundedAddress = addressService.getAddressById(id);
        return new ResponseEntity<>(foundedAddress, HttpStatus.OK);
    }

    @GetMapping("/address")
    public ResponseEntity<List<Address>> findAllAddresses(){
        List<Address> allAddresses = addressService.getAllAddresses();
        return new ResponseEntity<>(allAddresses, HttpStatus.OK);
    }

    @PutMapping("/address")
    public Address editAddress(@RequestBody Address address){
        return addressService.updateAddress(address);
    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity<?> removeAddress(@PathVariable("id") Long id){
        addressService.deleteAddressById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
