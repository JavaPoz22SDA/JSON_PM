package pl.sda.student;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * @author Paweł Matyaszczyk
 */
public class StudentOperations {
    private List<Student> studentList = new ArrayList<Student>();

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void removeStudent(Student student) {
        if (studentList.remove(student)) {
            System.out.println("Usunięto studenta: " + student.getFirstName() + " " + student.getLastName());
        }
        else {
            System.out.println("Nie ma studenta na liście.");
        }
    }

    public void showStudents() {
        System.out.println("Studenci na liście:");
        for (Student s: studentList) {
            System.out.println(s.getFirstName() + " " + s.getLastName());
        }
    }

    public void saveStudentsToJSON() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(out, studentList);
            byte[] data = out.toByteArray();
            FileOutputStream file = new FileOutputStream("Students.json");
            file.write(data);
            file.close();
        }
        catch (IOException ex) {
        }
    }
}
