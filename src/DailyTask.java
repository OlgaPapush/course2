import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {
    public DailyTask(String title, String description, Type type, LocalDate task) {
        super(title, description, type, taskDateTime);
    }

    @Override
    public boolean isAvailable(LocalDate inputDate) {
        var strartDate :LocalDate = getDateTime().toLocalDate();
        while (!strartDate.isAfter(inputDate)) {
            if (strartDate.equals(inputDate)) {
                return true;
            }
            strartDate = strartDate.plusDays(1);
        }
        return false;
    }
}