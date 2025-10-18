public final class Task {
  private final String id;
  private String name;
  private String description;

  public Task(String id, String name, String description) {
    this.id = validateId(id);
    this.name = validateName(name);
    this.description = validateDescription(description);
  }

  public String getId() { return id; }
  public String getName() { return name; }
  public String getDescription() { return description; }

  public void setName(String name) { this.name = validateName(name); }
  public void setDescription(String description) { this.description = validateDescription(description); }

  private static String validateId(String id) {
    if (id == null) throw new IllegalArgumentException("Task id cannot be null");
    if (id.length() > 10) throw new IllegalArgumentException("Task id length > 10");
    return id;
  }
  private static String validateName(String name) {
    if (name == null) throw new IllegalArgumentException("Task name cannot be null");
    if (name.length() > 20) throw new IllegalArgumentException("Task name length > 20");
    return name;
  }
  private static String validateDescription(String description) {
    if (description == null) throw new IllegalArgumentException("Task description cannot be null");
    if (description.length() > 50) throw new IllegalArgumentException("Task description length > 50");
    return description;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Task)) return false;
    Task t = (Task) o;
    return id.equals(t.id);
  }
  @Override public int hashCode() { return id.hashCode(); }
}
