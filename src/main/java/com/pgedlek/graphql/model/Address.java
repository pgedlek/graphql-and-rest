package com.pgedlek.graphql.model;

public record Address(Integer id,
                      String street,
                      String city,
                      String state,
                      String country) {
}
