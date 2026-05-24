package org.example;
import java.util.List;
import java.util.stream.Collectors;

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

        String studentsJson = JsonUtil.serializeStudentList(students);                                //Сериализация коллекции студентов
        System.out.println(studentsJson);                                                             //Сериализация коллекции универов

        String universitiesJson = JsonUtil.serializeUniversityList(universities);
        System.out.println(universitiesJson);

        List<Student> studentsFromJson = JsonUtil.deserializeStudentList(studentsJson);               //Десериализация полученных коллекций студентов и добавление в новую коллекцию
        List<University> universitiesFromJson = JsonUtil.deserializeUniversityList(universitiesJson); //Десериализация полученных коллекций универов и добавление в новую коллекцию

        System.out.println("\n========= ПРОВЕРКА ДЕСЕРИАЛИЗАЦИИ =========");
        if (students.size() == studentsFromJson.size()){
            System.out.println("Десериализация студентов выполняется корректно");
        }else{
            System.out.println("Десериализация студентов выполняется не корректно");
        }

        if (universities.size() == universitiesFromJson.size()){
            System.out.println("Десериализация университетов выполняется корректно");
        }else{
            System.out.println("Десериализация университетов выполняется не корректно");
        }
        System.out.println("===========================================\n");
        students.stream()
                .map(JsonUtil::serializeStudent)
                .peek(System.out::println)
                .map(JsonUtil::deserializeStudent)
                .forEach(System.out::println);

        universities.stream()
                .map(JsonUtil::serializeUniversity)
                .peek(System.out::println)
                .map(JsonUtil::deserializeUniversity)
                .forEach(System.out::println);
        List<Statistics> statistics = CollectionUtil.getStatistics(students, universities);
        XlsWriter.writeStatistics(statistics,"Статистика.xlsx" );
    }
}