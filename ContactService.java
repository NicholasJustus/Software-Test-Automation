package contacts;

import java.util.*;

public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a contact with a unique ID
    public Contact addContact(Contact contact) {
        Objects.requireNonNull(contact, "contact must not be null");
        String id = contact.getContactId();
        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact ID already exists: " + id);
        }
        contacts.put(id, contact);
        return contact;
    }

    // Delete by ID
    public void deleteContact(String contactId) {
        if (contacts.remove(contactId) == null) {
            throw new NoSuchElementException("No contact with ID: " + contactId);
        }
    }

    // ---- helpers -------------------------------------------------------------
    private Contact getRequired(String contactId) {
        Contact c = contacts.get(contactId);
        if (c == null) throw new NoSuchElementException("No contact with ID: " + contactId);
        return c;
    }

    // ---- updaters ------------------------------------------------------------
    public void updateFirstName(String contactId, String firstName) {
        getRequired(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        getRequired(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        getRequired(contactId).setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        getRequired(contactId).setAddress(address);
    }

    // Optional: read-all (not required by rubric, handy for debugging)
    public Collection<Contact> getAll() {
        return Collections.unmodifiableCollection(contacts.values());
    }
}
