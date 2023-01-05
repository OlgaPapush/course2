import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {
    public WeeklyTask(String title, String description, Type type, LocalDateTime task) {
        super(title, description, type, taskDateTime);
    }

    @Override
    public boolean isAvailable(LocalDate inputDate) {
        var strartDate :LocalDate = getDateTime().toLocalDate();
        while (!strartDate.isAfter(inputDate)) {
            if (strartDate.equals(inputDate)) {
                return true;
            }
            strartDate = strartDate.plusWeeks(1);
        }
        return false;
    }
}
