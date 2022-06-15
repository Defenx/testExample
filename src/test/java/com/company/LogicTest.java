package com.company;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class LogicTest {

     Logic logic;
     Stream<User> positiveStream;
     Stream<User> negativeStream;

     final User firstUser = new User();
     final User secondUser = new User();
     final User thirdUser = new User();

    @BeforeEach
    void setUp() {
        logic = new Logic();

        Group firstGroup = new Group();
        firstGroup.setName("Hacker");
        Group secondGroup = new Group();
        secondGroup.setName("123");
        Group thirdGroup = new Group();
        thirdGroup.setName("val");
        Group fourthGroup = new Group();
        fourthGroup.setName("Jimmy");

        List<Group> groupsWithNullElement = new ArrayList<>();
        groupsWithNullElement.add(null);
        groupsWithNullElement.add(firstGroup);

        firstUser.setGroups(List.of(firstGroup, secondGroup, thirdGroup));
        secondUser.setGroups(List.of(secondGroup, fourthGroup));
        thirdUser.setGroups(groupsWithNullElement);

        positiveStream = Stream.of(firstUser, secondUser);
        negativeStream = Stream.of(firstUser, secondUser, thirdUser);
    }

    @Test
    void consumeTestWithPositiveData() {
        Assertions.assertEquals(
                List.of(firstUser),
                logic.consume(positiveStream));
    }

    @Test
    void consumeTestWithNegativeData() {
        Assertions.assertThrows(
                NullPointerException.class,
                () -> logic.consume(negativeStream));
    }

}