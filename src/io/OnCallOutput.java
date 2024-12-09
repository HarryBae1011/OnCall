package io;

import domain.MonthlyRoster;

public interface OnCallOutput {

    void printAskingMonthAndWeekDay();

    void printAskingWeekDayWorkers();

    void printAskingHolidayWorkers();

    void printRoster(MonthlyRoster monthlyroster);
}
