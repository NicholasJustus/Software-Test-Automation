package contacts;

import java.util.Objects;

public class Contact {
    private final String contactId; // not updatable
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        validateId(contactId);
        this.contactId = contactId;

        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    // ---- validation helpers -------------------------------------------------
    private static void require(boolean condition, String message) {
        if (!condition) throw new IllegalArgumentException(message);
    }

    private static boolean isTenDigits(String s) {
        if (s == null || s.length() != 10) return false;
        for (char c : s.toCharArray()) if (!Character.isDigit(c)) return false;
        return true;
    }

    private static void validateId(String id) {
        require(id != null && id.length() <= 10, "Contact ID must be non-null and ≤ 10 chars");
    }

    // ---- getters (no setter for ID) -----------------------------------------
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
    public String getPhone()     { return phone; }
    public String getAddress()   { return address; }

    // ---- setters with validation --------------------------------------------
    public void setFirstName(String firstName) {
        require(firstName != null && firstName.length() <= 10, "First name must be non-null and ≤ 10 chars");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        require(lastName != null && lastName.length() <= 10, "Last name must be non-null and ≤ 10 chars");
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        require(isTenDigits(phone), "Phone must be exactly 10 digits");
        this.phone = phone;
    }

    public void setAddress(String address) {
        require(address != null && address.length() <= 30, "Address must be non-null and ≤ 30 chars");
        this.address = address;
    }

    // equality by contactId (useful for collections)
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact that = (Contact) o;
        return contactId.equals(that.contactId);
    }
    @Override public int hashCode() { return Objects.hash(contactId); }
}
