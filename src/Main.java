import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Scheduler Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Execute Tasks");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter priority (1 = highest, 10 = lowest): ");
                    int priority = scanner.nextInt();

                    LocalDateTime deadline = LocalDateTime.now().plusMinutes(priority);
                    System.out.println("Deadline set to: " + deadline);

                    Task task = new Task(name, priority, deadline);
                    scheduler.addTask(task);
                    break;

                case 2:
                    if (scheduler.hasTasks()) {
                        scheduler.executeTasks();
                    } else {
                        System.out.println("No tasks to execute!");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}