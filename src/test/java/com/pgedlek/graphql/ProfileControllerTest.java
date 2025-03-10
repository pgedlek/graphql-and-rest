package com.pgedlek.graphql;

import com.pgedlek.graphql.controller.ProfileController;
import com.pgedlek.graphql.model.Profile;
import com.pgedlek.graphql.service.AddressService;
import com.pgedlek.graphql.service.ProfileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(ProfileController.class)
@ComponentScan(basePackages = "com.pgedlek.graphql")
class ProfileControllerTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private AddressService addressService;

    @Test
    void shouldRetrieveProfilesSuccessfully() {
        graphQlTester.documentName("profiles")
                .execute()
                .path("profiles")
                .entityList(Profile.class)
                .hasSize(2);
    }
}