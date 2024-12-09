package controller;

import domain.*;
import io.OnCallInput;
import io.OnCallOutput;
import service.RosterService;

import java.io.IOException;
import java.util.List;

public class OnCallController extends ExceptionLoopController{

    private final RosterService rosterService;
    private final OnCallInput input;
    private final OnCallOutput output;

    public OnCallController(RosterService rosterService, OnCallInput input, OnCallOutput output) {
        this.rosterService = rosterService;
        this.input = input;
        this.output = output;
    }

    public void makeRoster() throws IOException {

        MonthlyCalendar monthlyCalendar = makeMonthlyCalendar();

        CombinedRoster combinedRoster = makeCombinedRoster();
        MonthlyRoster monthlyRoster = rosterService.makeMonthlyRoster(monthlyCalendar, combinedRoster);
        output.printRoster(monthlyRoster);
    }

    private MonthlyCalendar makeMonthlyCalendar() throws IOException {
        output.printAskingMonthAndWeekDay();
        return input.getMonthAndDayOfWeek();
    }

    private CombinedRoster makeCombinedRoster() throws IOException {
        Roster weekDayRoster = makeWeekDayRoster();
        Roster holiDayRoster = makeHolidayRoster();
        return new CombinedRoster(weekDayRoster, holiDayRoster);
    }

    private Roster makeWeekDayRoster() throws IOException {
        output.printAskingWeekDayWorkers();
        List<Worker> weekdayWorkers = input.getWorkers();
        return new Roster(weekdayWorkers);
    }

    private Roster makeHolidayRoster() throws IOException {
        output.printAskingHolidayWorkers();
        List<Worker> holidayWorkers = input.getWorkers();
        return new Roster(holidayWorkers);
    }
}
