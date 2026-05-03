package org.example;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/universityInfo.xlsx";
        List<University> universities = XlsxReader.readUniversities(filePath, "Университеты");
        List<Student> students = XlsxReader.readStudents(filePath, "Студенты");

        System.out.println(" Университеты ");
        for (University u : universities) {
            System.out.println(u);
        }
        System.out.println("\n Студенты ");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}