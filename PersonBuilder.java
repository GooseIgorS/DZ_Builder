public class PersonBuilder {

    private String name;
    private String surname;
    private Integer age;
    private String address;

    public PersonBuilder setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Некорректное имя");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname.isBlank()) {
            throw new IllegalArgumentException("Некорректная фамилия");
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным: " + age);
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        if (address == null || address.isBlank()) {
            this.address = null;
        } else {
            this.address = address;
        }
        return this;
    }

    public Person build() {
        if (name == null || name.isBlank()) {
            throw new IllegalStateException("Невозможно создать Person: не указано имя");
        }
        if (surname == null || surname.isBlank()) {
            throw new IllegalStateException("Невозможно создать Person: не указана фамилия");
        }

        Person p = (age == null)
                ? new Person(name, surname)
                : new Person(name, surname, age);

        if (address != null) {
            p.setAddress(address);
        }
        return p;
    }
}
