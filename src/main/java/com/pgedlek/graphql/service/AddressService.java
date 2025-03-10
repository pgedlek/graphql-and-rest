package com.pgedlek.graphql.service;

import com.pgedlek.graphql.model.Address;
import com.pgedlek.graphql.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {
    @Autowired
    private final AddressRepository addressRepository;

    public Optional<Address> getAddress(Integer addressId) {
        return addressRepository.findById(addressId);
    }
}
