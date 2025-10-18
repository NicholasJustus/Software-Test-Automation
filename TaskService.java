import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class TaskService {
  private final Map<String, Task> tasks = new HashMap<>();

  public void addTask(String id, String name, String description) { addTask(new Task(id, name, description)); }

  public void addTask(Task task) {
    String id = task.getId();
    if (tasks.containsKey(id)) throw new IllegalArgumentException("Duplicate task id: " + id);
    tasks.put(id, task);
  }

  public boolean deleteTask(String id) { return tasks.remove(id) != null; }

  public void updateName(String id, String newName) { requireExisting(id).setName(newName); }

  public void updateDescription(String id, String newDescription) { requireExisting(id).setDescription(newDescription); }

  public Task get(String id) { return tasks.get(id); }

  public Map<String, Task> all() { return Collections.unmodifiableMap(tasks); }

  private Task requireExisting(String id) {
    Task t = tasks.get(id);
    if (t == null) throw new NoSuchElementException("Task not found: " + id);
    return t;
  }
}
