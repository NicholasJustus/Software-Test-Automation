import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaskTest {
  @Test @DisplayName("Valid Task is created; getters reflect values")
  void validTaskCreated() {
    Task t = new Task("ABC123", "Title", "Short description");
    assertAll(
      () -> assertEquals("ABC123", t.getId()),
      () -> assertEquals("Title", t.getName()),
      () -> assertEquals("Short description", t.getDescription())
    );
  }

  @Test void idCannotBeNull() { assertThrows(IllegalArgumentException.class, () -> new Task(null, "n", "d")); }
  @Test void idCannotExceed10Chars() {
    assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "n", "d"));
  }

  @Test void nameCannotBeNull() { assertThrows(IllegalArgumentException.class, () -> new Task("1", null, "d")); }
  @Test void nameCannotExceed20Chars() {
    String longName = "ABCDEFGHIJKLMNOPQRSTU"; // 21 chars
    assertThrows(IllegalArgumentException.class, () -> new Task("1", longName, "d"));
  }

  @Test void descriptionCannotBeNull() { assertThrows(IllegalArgumentException.class, () -> new Task("1", "n", null)); }
  @Test void descriptionCannotExceed50Chars() {
    String longDesc = "012345678901234567890123456789012345678901234567890"; // 51
    assertThrows(IllegalArgumentException.class, () -> new Task("1", "n", longDesc));
  }

  @Test
  void canUpdateNameAndDescription_withValidation() {
    Task t = new Task("1", "name", "desc");
    t.setName("New Name");
    t.setDescription("New Description");
    assertAll(
      () -> assertEquals("New Name", t.getName()),
      () -> assertEquals("New Description", t.getDescription())
    );
    assertThrows(IllegalArgumentException.class, () -> t.setName(null));
    assertThrows(IllegalArgumentException.class, () -> t.setDescription(null));
  }
}
