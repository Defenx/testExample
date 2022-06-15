package com.company;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Main {

    static final int startYear = 2020;
    static final int endYear = 2022;

    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(100, 500);

        List<UserOnline> onlineList = Stream.generate(Main::generateUser).limit(i).toList();

        LocalDate minStarSession = Collections.min(onlineList, Comparator.comparing(UserOnline::getStartSession))
                .getStartSession();

        int max = 0;
        int best = 0;

        LocalDate resDate = null;

        int countDay = (endYear - startYear) * 365; //

        for (int j = 0; j < countDay; j++) {
            if (j != 0) {
                minStarSession = minStarSession.plusDays(1);
            }
            for (UserOnline userOnline : onlineList) {
                LocalDate lds = userOnline.getStartSession();
                LocalDate lde = userOnline.getEndSession();

                if ((minStarSession.isAfter(lds) && minStarSession.isBefore(lde))
                        || (minStarSession.isEqual(lds)) || (minStarSession.isEqual(lde))
                ) {
                    max++;
                    if (best < max) {
                        best = max;
                        resDate = minStarSession;
                    }
                }
            }
            max = 0;
        }

        System.out.println("All users: " + onlineList.size());
        System.out.println("Maximum online:" + best);
        System.out.println("Date:" + resDate);


    }

    public LocalDate findMaxOnlineDateForTest(List<UserOnline> onlineList) {

        LocalDate minStarSession = Collections.min(onlineList, Comparator.comparing(UserOnline::getStartSession))
                .getStartSession();

        int max = 0;
        int best = 0;

        LocalDate resDate = null;

        int countDay = (endYear - startYear) * 365;

        for (int j = 0; j < countDay; j++) {
            if (j != 0) {
                minStarSession = minStarSession.plusDays(1);
            }
            for (UserOnline userOnline : onlineList) {
                LocalDate lds = userOnline.getStartSession();
                LocalDate lde = userOnline.getEndSession();

                if ((minStarSession.isAfter(lds) && minStarSession.isBefore(lde))
                        || (minStarSession.isEqual(lds)) || (minStarSession.isEqual(lde))
                ) {
                    max++;
                    if (best < max) {
                        best = max;
                        resDate = minStarSession;
                    }
                }
            }
            max = 0;
        }

        return resDate;
    }

    public int findMaxOnlineForTest(List<UserOnline> onlineList) {

        LocalDate minStarSession = Collections.min(onlineList, Comparator.comparing(UserOnline::getStartSession))
                .getStartSession();

        int max = 0;
        int best = 0;


        int countDay = (endYear - startYear) * 365;

        for (int j = 0; j < countDay; j++) {
            if (j != 0) {
                minStarSession = minStarSession.plusDays(1);
            }
            for (UserOnline userOnline : onlineList) {
                LocalDate lds = userOnline.getStartSession();
                LocalDate lde = userOnline.getEndSession();

                if ((minStarSession.isAfter(lds) && minStarSession.isBefore(lde))
                        || (minStarSession.isEqual(lds)) || (minStarSession.isEqual(lde))
                ) {
                    max++;
                    if (best < max) {
                        best = max;
                    }
                }
            }
            max = 0;
        }


        return best;
    }

    public static UserOnline generateUser() {
        Random random = new Random();

        int randomYearStart = random.nextInt(startYear, endYear);
        int randomMonthStart = random.nextInt(1, 12);
        int randomDayStart = random.nextInt(1, Month.of(randomMonthStart).maxLength());
        int randomYearEnd = random.nextInt(startYear, endYear);
        int randomMonthEnd = random.nextInt(1, 12);
        int randomDayEnd = random.nextInt(1, Month.of(randomMonthEnd).maxLength());

        LocalDate startUserOnline = LocalDate.of(randomYearStart, randomMonthStart, randomDayStart);
        LocalDate endUserOnline = LocalDate.of(randomYearEnd, randomMonthEnd, randomDayEnd);

        if (startUserOnline.isAfter(endUserOnline)) {
            LocalDate temp = startUserOnline;
            startUserOnline = endUserOnline;
            endUserOnline = temp;
        }

        return new UserOnline(startUserOnline, endUserOnline);
    }

    public static UserOnline generateUserForTest(LocalDate startUserOnline, LocalDate endUserOnline) {

        if (startUserOnline.isAfter(endUserOnline)) {
            LocalDate temp = startUserOnline;
            startUserOnline = endUserOnline;
            endUserOnline = temp;
        }

        return new UserOnline(startUserOnline, endUserOnline);
    }
}