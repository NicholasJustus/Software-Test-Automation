package contacts;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void createValidContact() {
        Contact c = new Contact("id1", "John", "Doe", "1234567890", "1 Main St");
        assertEquals("id1", c.getContactId());
        assertEquals("John", c.getFirstName());
        assertEquals("Doe",  c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals("1 Main St", c.getAddress());
    }

    @Test
    void idMustBeNonNullAndMax10() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact(null, "A", "B", "1234567890", "Addr"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("01234567890", "A", "B", "1234567890", "Addr")); // 11 chars
    }

    @Test
    void firstNameValidation() {
        Contact c = new Contact("id2", "Jane", "Doe", "1234567890", "Addr");
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName("ABCDEFGHIJK")); // 11
    }

    @Test
    void lastNameValidation() {
        Contact c = new Contact("id3", "Jane", "Doe", "1234567890", "Addr");
        assertThrows(IllegalArgumentException.class, () -> c.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> c.setLastName("ABCDEFGHIJK")); // 11
    }

    @Test
    void phoneMustBeExactly10Digits() {
        Contact c = new Contact("id4", "Jane", "Doe", "1234567890", "Addr");
        assertThrows(IllegalArgumentException.class, () -> c.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("123"));           // too short
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("12345678901"));   // too long
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("123456789a"));    // non-digit
    }

    @Test
    void addressValidation() {
        Contact c = new Contact("id5", "Jane", "Doe", "1234567890", "Addr");
        assertThrows(IllegalArgumentException.class, () -> c.setAddress(null));
        assertThrows(IllegalArgumentException.class,
            () -> c.setAddress("1234567890123456789012345678901")); // 31
    }
}
