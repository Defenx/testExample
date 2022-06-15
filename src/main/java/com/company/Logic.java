package com.company;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Logic {
    public List<User> consume(Stream<User> usersStream) {
        return usersStream
                .filter(user -> user.getGroups()
                        .stream()
                        .anyMatch(group -> group.getName().startsWith("H")))
                .collect(Collectors.toList());
    }
}
