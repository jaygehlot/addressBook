package model;

import java.time.LocalDate;
import java.util.Objects;

public class Person {

    private String name;
    private Gender gender;
    private LocalDate localDate;

    public Person(String name, Gender gender, LocalDate localDate) {
        this.name = name;
        this.gender = gender;
        this.localDate = localDate;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                gender == person.gender &&
                Objects.equals(localDate, person.localDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, localDate);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", localDate=" + localDate +
                '}';
    }
}
