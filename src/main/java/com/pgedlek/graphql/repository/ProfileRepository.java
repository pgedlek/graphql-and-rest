package com.pgedlek.graphql.repository;

import com.pgedlek.graphql.model.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class ProfileRepository {
    List<Profile> profiles = Arrays.asList(
            new Profile(1, "John", "Doe", "jdoe@email.com", 18, 1),
            new Profile(2, "Jane", "Smith", "jsmith@example.com", 39, 2)
    );

    public List<Profile> findAll() {
        return profiles;
    }

    public Optional<Profile> findById(Integer id) {
        return profiles.stream()
                .filter(profile -> profile.id().equals(id))
                .findFirst();
    }
}
