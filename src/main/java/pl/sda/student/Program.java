package pl.sda.student;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Paweł Matyaszczyk
 */
public class Program {
    final static String ADD_STUDENT = "Dodawanie studenta";
    final static String REMOVE_STUDENT = "Usuwanie wybranego studenta";
    final static String SHOW_STUDENTS = "Wyświetlanie studentów";
    final static String SAVE_STUDENTS_TO_JSON = "Zapisania studentów do pliku json";
    final static String EXIT = "Zakończ program";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        StudentOperations studentOperations = new StudentOperations();
        Menu menu = new Menu();
        menu.add(ADD_STUDENT);
        menu.add(REMOVE_STUDENT);
        menu.add(SHOW_STUDENTS);
        menu.add(SAVE_STUDENTS_TO_JSON);
        menu.add(EXIT);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("Students.json");
            for (Student student : objectMapper.readValue(file,Student[].class)) {
                studentOperations.addStudent(student);
            }
        }
        catch (Exception ex){

        }

        while (true){
            switch ((String)menu.showAndGetSelected()) {
                case ADD_STUDENT:
                    System.out.println("Dodawanie studenta: ");
                    System.out.println("Podaj imię: ");
                    String addfirstName = scanner.nextLine().trim();
                    System.out.println("Podaj nazwisko: ");
                    String addlastName = scanner.nextLine().trim();
                    Student addStudent = new Student(addfirstName,addlastName);
                    studentOperations.addStudent(addStudent);
                    break;

                case REMOVE_STUDENT:
                    System.out.println("Usuwanie studenta: ");
                    System.out.println("Podaj imię: ");
                    String removeFirstName = scanner.nextLine().trim();
                    System.out.println("Podaj nazwisko: ");
                    String removeLastName = scanner.nextLine().trim();
                    Student removeStudent = new Student(removeFirstName,removeLastName);
                    studentOperations.removeStudent(removeStudent);
                    break;

                case SHOW_STUDENTS:
                    studentOperations.showStudents();
                    break;
                case SAVE_STUDENTS_TO_JSON:
                    studentOperations.saveStudentsToJSON();
                    break;
                default:
                    System.exit(1);
            }

        }

    }
}
