package com.lottyx.lottyxbackend.service;

import com.lottyx.lottyxbackend.model.Address;

import java.util.List;

public interface AddressService {
    public Address postNewAddress( Address address);
    public Address getAddressById(Long id);
    public List<Address> getAllAddresses();
    public Address updateAddress(Address address);
    public void deleteAddressById(Long id);
}
