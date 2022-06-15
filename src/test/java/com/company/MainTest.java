package com.company;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class MainTest {

    Main main;
    UserOnline positiveUserOnline;
    UserOnline negativeUserOnline;

    List<UserOnline> userOnlineList;

    List<UserOnline> secondUserOnlineList;

    @BeforeEach
    void setUp() {
        main = new Main();
        positiveUserOnline = new UserOnline(LocalDate.of(2020, Month.APRIL, 20),
                LocalDate.of(2021, Month.FEBRUARY, 13));
        negativeUserOnline = new UserOnline(LocalDate.of(2021, Month.FEBRUARY, 13),
                LocalDate.of(2020, Month.APRIL, 20));

        userOnlineList = List.of(
                new UserOnline(
                        LocalDate.of(2021, Month.APRIL, 10),
                        LocalDate.of(2022, Month.SEPTEMBER, 25)
                ),
                new UserOnline(
                        LocalDate.of(2020, Month.JANUARY, 1),
                        LocalDate.of(2021, Month.MARCH, 16)
                ),
                new UserOnline(
                        LocalDate.of(2021, Month.FEBRUARY, 17),
                        LocalDate.of(2021, Month.MARCH, 6)
                ),
                new UserOnline(
                        LocalDate.of(2020, Month.MAY, 13),
                        LocalDate.of(2021, Month.JUNE, 9)
                ),
                new UserOnline(
                        LocalDate.of(2021, Month.APRIL, 22),
                        LocalDate.of(2022, Month.APRIL, 23)
                ),
                new UserOnline(
                        LocalDate.of(2021, Month.APRIL, 11),
                        LocalDate.of(2022, Month.DECEMBER, 20)
                )
        );

        secondUserOnlineList = new ArrayList<>(userOnlineList);
        for (int i = 0; i < 10; i++) {
            secondUserOnlineList.add(new UserOnline(
                    LocalDate.of(2021, Month.DECEMBER, 11),
                    LocalDate.of(2022, Month.DECEMBER, 20)
            ));
        }

    }

    @Test
    void findMaxOnlineDateAndCountOfPersonPositiveTest() {
        Assertions.assertEquals(4, main.findMaxOnlineForTest(userOnlineList));
        Assertions.assertEquals(LocalDate.of(2021, Month.APRIL, 22),
                main.findMaxOnlineDateForTest(userOnlineList));

        Assertions.assertEquals(13, main.findMaxOnlineForTest(secondUserOnlineList));
        Assertions.assertEquals(LocalDate.of(2021, Month.DECEMBER, 11),
                main.findMaxOnlineDateForTest(secondUserOnlineList));
    }

    @Test
    void positiveGenerateUserTest() {
        Assertions.assertEquals(new UserOnline(positiveUserOnline.getStartSession(),
                        positiveUserOnline.getEndSession()),
                Main.generateUserForTest(positiveUserOnline.getStartSession(),
                        positiveUserOnline.getEndSession()));

        Assertions.assertEquals(new UserOnline(negativeUserOnline.getEndSession(),
                        negativeUserOnline.getStartSession()),
                Main.generateUserForTest(negativeUserOnline.getStartSession(),
                        negativeUserOnline.getEndSession()));
    }

}