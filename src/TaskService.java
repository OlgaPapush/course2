import java.time.LocalDate;
import java.util.*;

public class TaskService {
    private Map<Integer, Task> taskMap = new HashMap<>();
    private Collection<Task> removedTasks;

    public void add(Task task) {
        taskMap.put(task.getId(), task);
    }

    public void remove(int id) {
        taskMap.remove(id);
    }

    public Collection<Task> getAllByDate(LocalDate InputDate) {
        List<Task> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Task> IntegerTaskEntry : taskMap.entrySet()) {
            var task :Task = integerTaskEntry.getValue();
            if (task.isAvailable(inputDate)) {
                resultList.add(task);
            }
        }
        return resultList;

    }
}
