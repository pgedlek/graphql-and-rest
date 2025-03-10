package com.pgedlek.graphql.repository;

import com.pgedlek.graphql.model.Address;
import com.pgedlek.graphql.model.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class AddressRepository {
    List<Address> addresses = Arrays.asList(
        new Address(1, "Main St", "London", "Greater London", "UK"),
        new Address(2, "Long St", "Chicago", "Illinois", "USA")
    );

    public Optional<Address> findById(Integer id) {
        return addresses.stream()
                .filter(address -> address.id().equals(id))
                .findFirst();
    }
}
