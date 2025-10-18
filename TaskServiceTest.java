import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
  @Test @DisplayName("Add tasks with unique IDs; reject duplicates")
  void addUniqueAndRejectDuplicates() {
    TaskService svc = new TaskService();
    svc.addTask("t1", "A", "B");
    assertNotNull(svc.get("t1"));
    assertThrows(IllegalArgumentException.class, () -> svc.addTask("t1", "X", "Y"));
  }

  @Test @DisplayName("Delete by ID returns true when removed; false if not present")
  void deleteById() {
    TaskService svc = new TaskService();
    svc.addTask("t1", "A", "B");
    assertTrue(svc.deleteTask("t1"));
    assertFalse(svc.deleteTask("t1"));
  }

  @Test @DisplayName("Update name/description by ID")
  void updateNameAndDescription() {
    TaskService svc = new TaskService();
    svc.addTask("t1", "A", "B");
    svc.updateName("t1", "New");
    svc.updateDescription("t1", "New Desc");
    Task t = svc.get("t1");
    assertAll(
      () -> assertEquals("New", t.getName()),
      () -> assertEquals("New Desc", t.getDescription())
    );
  }

  @Test @DisplayName("Update throws if ID not found")
  void updateUnknownIdThrows() {
    TaskService svc = new TaskService();
    assertThrows(NoSuchElementException.class, () -> svc.updateName("missing", "x"));
    assertThrows(NoSuchElementException.class, () -> svc.updateDescription("missing", "y"));
  }
}
