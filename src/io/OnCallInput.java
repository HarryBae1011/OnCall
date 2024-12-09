package io;

import domain.MonthlyCalendar;
import domain.Worker;

import java.io.IOException;
import java.util.List;

public interface OnCallInput {

    MonthlyCalendar getMonthAndDayOfWeek() throws IOException;

    List<Worker> getWorkers() throws IOException;
}
