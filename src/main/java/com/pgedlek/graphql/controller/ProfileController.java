package com.pgedlek.graphql.controller;

import com.pgedlek.graphql.model.Address;
import com.pgedlek.graphql.model.Profile;
import com.pgedlek.graphql.service.AddressService;
import com.pgedlek.graphql.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ProfileController {
    @Autowired
    private final ProfileService profileService;

    @Autowired
    private final AddressService addressService;

    @QueryMapping
    public List<Profile> profiles() {
        return profileService.getAllProfiles();
    }

    @QueryMapping
    public Optional<Profile> profileById(@Argument Integer id) {
        return profileService.getProfile(id);
    }

    @SchemaMapping
    public Optional<Address> address(Profile profile) {
        return addressService.getAddress(profile.addressId());
    }
}
