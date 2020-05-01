package pl.sda.student;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author Paweł Matyaszczyk
 */
public class Student {
    public String firstName;
    public String lastName;

    public Student() {
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student student = (Student) obj;
        return getFirstName().equals(student.getFirstName()) && getLastName().equals(student.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(),getLastName());
    }
}
