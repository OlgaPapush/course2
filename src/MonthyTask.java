import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthyTask extends Task {
    public MonthyTask(String title, String description, Type type, LocalDateTime task) {
        super(title, description, type, taskDateTime);
    }

    @Override
    public boolean isAvailable(LocalDate inputDate) {
        var strartDate :LocalDateTime = getDateTime().toLocalDate();
        while (!strartDate.isAfter(inputDate)) {
            if (strartDate.equals(inputDate)) {
                return true;
            }
            strartDate = strartDate.plusMoths(1);
        }
        return false;
    }
}