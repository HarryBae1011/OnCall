package domain;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.MonthDay;

public class MonthlyCalendar {

    private final Month month;
    private final DayOfWeek startDayOfWeek;

    public MonthlyCalendar(Month month, DayOfWeek dayOfWeek) {
        this.month = month;
        this.startDayOfWeek = dayOfWeek;
    }

    public RosterDay get(int day) {
        return new RosterDay(MonthDay.of(month, day), startDayOfWeek.plus(day-1L));
    }

    public int getLastDay() {
        return month.minLength();
    }
}
