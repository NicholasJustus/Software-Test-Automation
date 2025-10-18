package contacts;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

    private ContactService service;
    private Contact base;

    @BeforeEach
    void setup() {
        service = new ContactService();
        base = new Contact("id1", "John", "Doe", "1234567890", "1 Main St");
        service.addContact(base);
    }

    @Test
    void addContactWithDuplicateIdFails() {
        Contact dup = new Contact("id1", "Jane", "Smith", "1112223333", "2 Oak St");
        assertThrows(IllegalArgumentException.class, () -> service.addContact(dup));
    }

    @Test
    void deleteExistingContact() {
        assertDoesNotThrow(() -> service.deleteContact("id1"));
        assertThrows(NoSuchElementException.class, () -> service.deleteContact("id1"));
    }

    @Test
    void deleteMissingContactFails() {
        assertThrows(NoSuchElementException.class, () -> service.deleteContact("nope"));
    }

    @Test
    void updateFieldsHappyPath() {
        service.updateFirstName("id1", "Alice");
        service.updateLastName("id1", "Jones");
        service.updatePhone("id1", "0987654321");
        service.updateAddress("id1", "5 Elm St");

        Contact c = service.getAll().iterator().next();
        assertEquals("Alice", c.getFirstName());
        assertEquals("Jones", c.getLastName());
        assertEquals("0987654321", c.getPhone());
        assertEquals("5 Elm St", c.getAddress());
    }

    @Test
    void updateWithInvalidValuesThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("id1", null));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("id1", "ABCDEFGHIJK")); // 11
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("id1", "123"));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("id1", null));
    }

    @Test
    void updateMissingContactThrows() {
        assertThrows(NoSuchElementException.class, () -> service.updateFirstName("nope", "A"));
    }
}
