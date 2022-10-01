package com.lottyx.lottyxbackend.service;

import com.lottyx.lottyxbackend.exception.AddressNotFoundException;
import com.lottyx.lottyxbackend.exception.DrawNotFoundException;
import com.lottyx.lottyxbackend.model.Address;
import com.lottyx.lottyxbackend.model.EuroDraw;
import com.lottyx.lottyxbackend.model.User;
import com.lottyx.lottyxbackend.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService{


    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl( AddressRepository addressRepository ) {
        this.addressRepository = addressRepository;
    }


    @Override
    public Address postNewAddress( Address address ) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddressById( Long id ) {
        return addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(
                "LOTTYX : Address with ID = " + id + " NOT found in database"));
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address updateAddress( Address address ) {
        Address addressFound = addressRepository.findById(address.getId()).orElseThrow(() -> new AddressNotFoundException(
                "LOTTYX : Address with ID = " + address.getId() + " NOT found i database"));

        addressFound.setStreet(address.getStreet());
        addressFound.setStreetNumber(address.getStreetNumber());
        addressFound.setStreetAdditional(address.getStreetAdditional());
        addressFound.setCity(address.getCity());
        addressFound.setCountry(address.getCountry());
        addressFound.setZipCode(address.getZipCode());

        return addressRepository.save(addressFound);
    }

    @Override
    public void deleteAddressById( Long id ) {
        addressRepository.deleteById(id);
    }
}
