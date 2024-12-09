import controller.OnCallController;
import io.OnCallConsoleInput;
import io.OnCallConsoleOutput;
import service.RosterService;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {

        OnCallConsoleInput input = new OnCallConsoleInput();
        OnCallConsoleOutput output = new OnCallConsoleOutput();

        RosterService rosterService = new RosterService();
        OnCallController onCallController = new OnCallController(rosterService, input, output);

        onCallController.makeRoster();
    }
}