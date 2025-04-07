import java.time.LocalDateTime;

public class Task implements Comparable<Task> {
    private String name;
    private int priority; // Lower number = higher priority (e.g., 1 is highest)
    private LocalDateTime deadline;

    public Task(String name, int priority, LocalDateTime deadline) {
        this.name = name;
        this.priority = priority;
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    @Override
    public int compareTo(Task other) {
        int priorityComparison = Integer.compare(this.priority, other.priority);
        if (priorityComparison != 0) {
            return priorityComparison;
        }
        return this.deadline.compareTo(other.deadline);
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", deadline=" + deadline + "}";
    }
}