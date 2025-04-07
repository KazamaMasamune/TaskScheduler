import java.util.PriorityQueue;

public class TaskScheduler {
    private PriorityQueue<Task> taskQueue;

    public TaskScheduler() {
        this.taskQueue = new PriorityQueue<>();
    }

    public void addTask(Task task) {
        taskQueue.offer(task);
        System.out.println("Added: " + task);
    }

    public void executeTasks() {
        System.out.println("Executing tasks...");
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println("Executing: " + task);
            try {
                Thread.sleep(1000); // Simulate task execution
            } catch (InterruptedException e) {
                System.err.println("Task execution interrupted: " + e.getMessage());
            }
        }
        System.out.println("All tasks completed!");
    }

    public boolean hasTasks() {
        return !taskQueue.isEmpty();
    }
}