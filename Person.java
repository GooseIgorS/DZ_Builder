import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    private boolean ageKnown;
    private String address;

    public Person(String name, String surname) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя обязательно и не может быть пустым");
        }
        if (surname == null || surname.isBlank()) {
            throw new IllegalArgumentException("Фамилия обязательна и не может быть пустой");
        }
        this.name = name;
        this.surname = surname;
        this.ageKnown = false;
    }

    public Person(String name, String surname, int age) {
        this(name, surname);
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным: " + age);
        }
        this.age = age;
        this.ageKnown = true;
    }

    public boolean hasAge() {
        return ageKnown;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return ageKnown ? OptionalInt.of(age) : OptionalInt.empty();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.isBlank()) {
            this.address = null;
            return;
        }
        this.address = address;
    }

    public void happyBirthday() {
        if (!ageKnown) {
            throw new IllegalStateException("Нельзя увеличить возраст: возраст неизвестен");
        }
        age += 1;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAge(0)
                .setAddress(this.address);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ").append(surname);
        if (ageKnown) sb.append(", ").append(age);
        if (address != null) sb.append(" из ").append(address);
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, ageKnown, ageKnown ? age : null, address);
    }
}
