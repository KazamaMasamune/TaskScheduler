import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

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

                    int priority;
                    do {
                        System.out.print("Enter priority (1 = highest, 10 = lowest): ");
                        priority = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        if (priority < 1 || priority > 10) {
                            System.out.println("Invalid priority. Please enter a number between 1 and 10.");
                        }
                    } while (priority < 1 || priority > 10);

                    System.out.print("Enter deadline (yyyy-MM-dd HH:mm, e.g., 2025-04-19 14:30): ");
                    String deadlineInput = scanner.nextLine();
                    LocalDateTime deadline;
                    try {
                        deadline = LocalDateTime.parse(deadlineInput, formatter);
                        if (deadline.isBefore(LocalDateTime.now())) {
                            System.out.println("Deadline cannot be in the past. Setting to now.");
                            deadline = LocalDateTime.now();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date format. Setting deadline to now.");
                        deadline = LocalDateTime.now();
                    }

                    Task task = new Task(name, priority, deadline);
                    scheduler.addTask(task);
                    System.out.println("Task successfully added to the scheduler!");
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