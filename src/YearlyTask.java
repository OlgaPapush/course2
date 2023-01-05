import java.time.LocalDateTime;

public class YearlyTask extends Task {
    public YearlyTask(String title, String description, Type type, LocalDateTime task) {
        super(title, description, type, taskDateTime);

        @Override
        public boolean isAvailable (LocalDate inputDate){
            var strartDate :LocalDate = getDateTime().toLocalDate();
            while (!strartDate.isAfter(inputDate)) {
                if (strartDate.equals(inputDate)) {
                    return true;
                }
                strartDate = strartDate.plusYears(1);
            }
            return false;
        }
    }
}
