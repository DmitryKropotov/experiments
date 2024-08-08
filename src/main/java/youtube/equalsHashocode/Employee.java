package youtube.equalsHashocode;

import java.util.Objects;

public class Employee {
    String position;
    int age;
    String name;
    String surname;

    public Employee(String position, int age, String name, String surname) {
        this.position = position;
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(position);
        result = 31 * result + age;
        return result;
    }
}
