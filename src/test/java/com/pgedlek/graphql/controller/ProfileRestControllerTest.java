package com.pgedlek.graphql.controller;

import com.pgedlek.graphql.model.Profile;
import com.pgedlek.graphql.service.ProfileService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProfileRestControllerTest {
    public static final Profile PROFILE = new Profile(1, "First", "Last", "name@mail.eu", 88, 5);
    List<Profile> PROFILE_LIST = Collections.singletonList(PROFILE);

    @Mock
    private ProfileService profileServiceMock;

    @InjectMocks
    private ProfileRestController profileRestController;

    @Test
    void shouldRetrieveProfilesSuccessfully() {
        when(profileServiceMock.getAllProfiles()).thenReturn(PROFILE_LIST);

        List<Profile> profiles = profileRestController.profiles();

        assertThat(profiles).isSameAs(PROFILE_LIST);
    }

    @Test
    void shouldReturnSingleProfile() {
        when(profileServiceMock.getProfile(1)).thenReturn(Optional.of(PROFILE));

        Optional<Profile> profile = profileRestController.profileById(1);

        assertThat(profile).isNotEmpty();
        assertThat(profile.get()).isSameAs(PROFILE);
    }

    @Test
    void shouldReturnOptionalEmptyWhenCannotFindProfile() {
        Optional<Profile> profile = profileRestController.profileById(1111);

        assertThat(profile).isEmpty();
    }
}