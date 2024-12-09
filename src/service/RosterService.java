package service;

import domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RosterService {

    private Worker previousWorker;

    public MonthlyRoster makeMonthlyRoster(MonthlyCalendar monthlyCalendar, CombinedRoster combinedRoster) {
        List<DailyRoster> rosters = new ArrayList<>();

        for (RosterDay rosterDay : getRosterDays(monthlyCalendar)) {
            Worker worker = getWorker(combinedRoster, rosterDay);
            rosters.add(new DailyRoster(rosterDay, worker));
        }

        return new MonthlyRoster(rosters);
    }

    private Worker getWorker(CombinedRoster combinedRoster, RosterDay rosterDay) {
        Worker worker = combinedRoster.getWorker(rosterDay, previousWorker);
        previousWorker = worker;
        return worker;
    }

    private List<RosterDay> getRosterDays(MonthlyCalendar monthlyCalendar) {
        return IntStream.rangeClosed(1, monthlyCalendar.getLastDay())
                .mapToObj(monthlyCalendar::get)
                .toList();
    }
}
