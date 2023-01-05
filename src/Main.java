import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        try (Scanner scanner = new Scanner(System.in)) {
            TaskService service = new TaskService();
            label:
            while (true) {
                printMenu();
                System.out.println("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    switch (menu) {
                        case 1:
                            addTask(taskService, scanner);
                        case 2:
                            removeTask(taskServise, scanner);
                        case 3:
                            getTaskByDay(taskService, scanner);
                        case 4:
                            service.getAllTaskFromTaskList();
                        case 5:
                            taskList.editTask(scanner);
                        case 6:
                            taskList.getDelite();
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner next ();
                    System.out.println("Выбери пункт из списка");
                }
            }
        }
    }

    private static void addTask(TaskService taskService, Scanner scanner) {
        System.out.println("Введите название задачи: ");
        String name = scanner.next();
        scanner.nextLine();
        System.out.println("Введите описание задачи: ");
        String description = scanner.nextLine();
        System.out.println("Введите дату задачи в формате dd.mm.yyyy: ");
        String date = scanner.nextLine();
        LocalDate taskDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.mm.yyyy"));
        String time = scanner.nextLine();
        LocalTime taskTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("hh:mm"));
        System.out.println("Введите время задачи в формате hh:mm ");
        LocalDateTime resultDate = LocalDateTime.of(taskDate, taskTime);
        System.out.println("Введите тип задачи: Личный(1) или рабочий (2)");
        int type = scanner.nextInt();
        Type taskType = type == 1 ? Type.PERSONAL : Type.WORK;
        System.out.println("Введите повторяемость задачи:");
        System.out.println("0 - не повторяется");
        System.out.println("1  - дневная");
        System.out.println("2 - недельная");
        System.out.println("3 - месячная");
        System.out.println("4 - годовая");
        int typeTask = scanner.nextInt();
        switch (typeTask) {
            case 0:
                taskServise.add(new Task(name, description, taskType, resultDate));
                break;
            case 1:
                taskServise.add(new DailyTask(name, description, taskType, resultDate));
                break;
            case 2:
                taskServise.add(new WeeklyTask(name, description, taskType, resultDate));
                break;
            case 3:
                taskServise.add(new MonthyTask(name, description, taskType, resultDate));
                break;
            case 4:
                taskServise.add(new YearlyTask(name, description, taskType, resultDate));
                break;
            default:
                throw new RuntimeException("Нет такого типа задач");


        }
    }

    private static void removeTask(TaskService taskService, Scanner scanner) {
        System.out.println("id задачи, которую нужно удалить");
        int id = scanner.nextInt();
        taskService.remove(id);
    }

    private static void getTaskByDay(TaskService taskService, Scanner scanner) {
        System.out.println("Введите дату задачи в формате dd.mm.yyyy: ");
        String date = scanner.nextLine();
        LocalDate taskDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.mm.yyyy"));
        var allTaskByDay :Collection<Task> =taskService.getAllByDate(taskDate);
        System.out.println("Задачи на деньЖ");
        for (Task task : allTaskByDay) {
            System.out.println(task);
        }

    }

    private static void printMenu() {
        System.out.println(
                "1 Добавить задачу\n" +
                        "2 Удалить задачу\n" +
                        "3 Получить задачи на указанный день\n" +
                        "4 Получить все задачи\n" +
                        "5 Редактировать заголовок и описание задачи\n" +
                        "6 Получить список всех удаленных задач\n" +
                        "0 Выход\n");
    }
}


