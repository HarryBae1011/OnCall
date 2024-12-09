package io;

import domain.MonthlyCalendar;
import domain.Worker;
import exception.IllegalInputException;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OnCallConsoleInput implements OnCallInput{

    private static final String DELIMETER = ",";

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public MonthlyCalendar getMonthAndDayOfWeek() throws IOException {
        String[] input = br.readLine().split(DELIMETER);

        validateMonthDayInput(input);

        Month month = parseMonth(input[0]);
        DayOfWeek dayOfWeek = parseDayOfWeek(input[1]);
        return new MonthlyCalendar(month, dayOfWeek);
    }

    @Override
    public List<Worker> getWorkers() throws IOException {
        String[] input = br.readLine().split(DELIMETER);
        return Arrays.stream(input)
                .map(Worker::new)
                .toList();
    }

    private Month parseMonth(String s) {
        try{
            int month = Integer.parseInt(s);
            return Month.of(month);
        } catch (NumberFormatException | DateTimeException e) {
            throw new IllegalInputException();
        }
    }

    private DayOfWeek parseDayOfWeek(String s) {
        final Map<String, DayOfWeek> dayOfWeekMap = Map.of(
                "월", DayOfWeek.MONDAY,
                "화", DayOfWeek.TUESDAY,
                "수", DayOfWeek.WEDNESDAY,
                "목", DayOfWeek.THURSDAY,
                "금", DayOfWeek.FRIDAY,
                "토", DayOfWeek.SATURDAY,
                "일", DayOfWeek.SUNDAY
        );

        if (!dayOfWeekMap.containsKey(s)) {
            throw new IllegalInputException();
        }
        return dayOfWeekMap.get(s);
    }

    private void validateMonthDayInput(String[] input) {
        if (input.length != 2) {
            throw new IllegalInputException();
        }
    }
}
