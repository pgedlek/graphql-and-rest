package com.pgedlek.graphql.controller;

import com.pgedlek.graphql.model.Profile;
import com.pgedlek.graphql.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProfileRestController {
    @Autowired
    private final ProfileService profileService;

    @GetMapping("/profiles")
    public List<Profile> profiles() {
        return profileService.getAllProfiles();
    }

    @GetMapping("/profile/{profileId}")
    public Optional<Profile> profileById(@PathVariable Integer profileId) {
        return profileService.getProfile(profileId);
    }
}
