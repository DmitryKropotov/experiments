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

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }





    //    @Override
//    public final boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Employer)) return false;
//
//        Employer employer = (Employer) o;
//        return age == employer.age && Objects.equals(name, employer.name) && Objects.equals(surname, employer.surname);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = age;
//        result = 31 * result + Objects.hashCode(name);
//        result = 31 * result + Objects.hashCode(surname);
//        return result;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Employee employer = (Employee) o;
//        return age == employer.age && Objects.equals(name, employer.name) && Objects.equals(surname, employer.surname);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = age;
//        result = 31 * result + Objects.hashCode(name);
//        result = 31 * result + Objects.hashCode(surname);
//        return result;
//    }
}
