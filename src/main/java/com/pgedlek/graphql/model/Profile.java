package com.pgedlek.graphql.model;

public record Profile(Integer id,
                      String firstName,
                      String lastName,
                      String email,
                      Integer age,
                      Integer addressId) {
}
