package com.pgedlek.graphql;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Book(Integer id, String name, Integer pageCount, Integer authorId) {
    public static List<Book> books = Arrays.asList(
            new Book(1, "Quran", 604, 1),
            new Book(2, "Harry Potter", 708, 1),
            new Book(3, "Foobar", 101, 2),
            new Book(4, "Spring boot", 345, 2)
    );

    public static Optional<Book> getBookById(Integer id) {
        return books.stream()
                .filter(b -> b.id.equals(id))
                .findFirst();
    }
}
