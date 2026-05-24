package org.example;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Map;
import java.util.OptionalDouble;


public class CollectionUtil {
    private CollectionUtil() {
    }

    public static List<Statistics> getStatistics(List<Student> students, List<University> universities) {
        Map<StudyProfile, List<University>> universitiesByProfile = universities.stream()
                .collect(Collectors.groupingBy(University::getMainProfile));

        List<Statistics> result = new ArrayList<>();

        for (Map.Entry<StudyProfile, List<University>> entry : universitiesByProfile.entrySet()) {
            StudyProfile profile = entry.getKey();
            List<University> unisOfProfile = entry.getValue();
            int universitiesCount = unisOfProfile.size();
            List<String> uniNames = unisOfProfile.stream()
                    .map(University::getFullName)
                    .collect(Collectors.toList());
            List<Student> studentsOfProfile = students.stream()
                    .filter(student -> {
                        return unisOfProfile.stream().anyMatch(uni -> uni.getId().equals(student.getUniversityId()));
                    })
                    .collect(Collectors.toList());
            int studentsCount = studentsOfProfile.size();
            OptionalDouble avg = studentsOfProfile.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            double avgScore = avg.orElse(0.0);
            BigDecimal bd = BigDecimal.valueOf(avgScore).setScale(2, RoundingMode.HALF_UP);
            float roundedAvg = bd.floatValue();
            Statistics stat = new Statistics(profile, roundedAvg, studentsCount, universitiesCount, uniNames);
            result.add(stat);
        }
        return result;
    }
}

