
package org.example;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.stream.Collectors;
import java.util.logging.Logger;


public class Main {
    private static Logger logger;

    public static void main(String[] args) {
        try {
            System.setProperty("java.util.logging.config.file", "logging.properties");
            LogManager.getLogManager().readConfiguration();
            logger = Logger.getLogger(Main.class.getName());
        } catch (IOException e) {
            logger = Logger.getLogger(Main.class.getName());
            logger.severe("Не удалось загрузить logging.properties: " + e.getMessage());
        }

        logger.info("Программа запущена");
        String filePath = "src/main/resources/universityInfo.xlsx";
        List<University> universities = XlsxReader.readUniversities(filePath, "Университеты");
        List<Student> students = XlsxReader.readStudents(filePath, "Студенты");
        logger.info("Файлы студентов прочитаны: " + students.size() + " и файлы университетов прочитаны: " + universities.size());

        StudentComparator studentComparator = ComparatorUtil.getStudentComparator(StudentComparators.StudentFullNameComparator);
        UniversityComparator universityComparator = ComparatorUtil.getUniversityComparator(UniversityComparators.UniversityShortNameComparator);
        students.stream()
                .sorted(studentComparator)
                .collect(Collectors.toList());
        logger.info("Студенты отсортированы: " + students.size());

        universities.stream()
                .sorted(universityComparator)
                .collect(Collectors.toList());
        logger.info("Университеты отсортированы: " + universities.size());


        List<Statistics> statistics = CollectionUtil.getStatistics(students, universities);
        XlsWriter.writeStatistics(statistics,"Статистика.xlsx" );
        Root root = new Root();

        List<StudentEntry> studentEntries = new ArrayList<>();
        for (Student student : students) {
            StudentEntry entry = new StudentEntry();
            entry.setStudentName(student.getFullName());
            entry.setUniversityId(student.getUniversityId());
            entry.setAvgScore(student.getAvgExamScore());
            studentEntries.add(entry);
        }
        root.setStudentsInfo(studentEntries);

        List<UniversityEntry> universityEntries = new ArrayList<>();
        for (University university : universities) {
            UniversityEntry entry = new UniversityEntry();
            entry.setUniversityName(university.getFullName());
            entry.setUniversityId(university.getId());
            entry.setUniversityProfile(university.getMainProfile().name());
            universityEntries.add(entry);
        }
        root.setUniversitiesInfo(universityEntries);

        List<StatisticsEntry> statisticsEntries = new ArrayList<>();
        for (Statistics stat : statistics) {
            StatisticsEntry entry = new StatisticsEntry();
            entry.setAvgScore(stat.getAvgExamScore());
            entry.setUniversityProfile(stat.getProfile().name());
            statisticsEntries.add(entry);
        }
        root.setStatisticalInfo(statisticsEntries);

        root.setProcessedAt(OffsetDateTime.now().toString());

        long timestamp = System.currentTimeMillis();
        String fileName = "xmlReqs/req_" + timestamp + ".xml";
        String JsonPath = "jsonReqs/req_" + timestamp + ".json";
        XmlWriter.writeRoot(root, fileName);
        JsonWriter.writeRoot(root, JsonPath);

        logger.info("Статистика собрана и записана в Excel");
    }

}