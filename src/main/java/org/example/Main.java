package org.example;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/universityInfo.xlsx";
        List<University> universities = XlsxReader.readUniversities(filePath, "Университеты");
        List<Student> students = XlsxReader.readStudents(filePath, "Студенты");

        StudentComparator studentComparator = ComparatorUtil.getStudentComparator(StudentComparators.StudentFullNameComparator);
        UniversityComparator universityComparator = ComparatorUtil.getUniversityComparator(UniversityComparators.UniversityShortNameComparator);
        System.out.println("Студенты:");
        students.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);

        System.out.println("\nУниверситеты:");
        universities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);
    }
}