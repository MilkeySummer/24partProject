package org.example;
public class Main {
    public static void main(String[] args) {
        University uni1 = new University()
                .setId("U001")
                .setFullName("Нижегородский Педагогический Университет")
                .setShortName("НГПУ")
                .setYearOfFoundation(1911)
                .setMainProfile(StudyProfile.IT);
        System.out.println(uni1);
        Student student1 = new Student()
                .setFullName("Чучаев Андрей Вадимович")
                .setUniversityId("U001")
                .setCurrentCourseNumber(1)
                .setAvgExamScore(4.3f);
        System.out.println(student1);
        Student student2 = new Student()
                .setFullName("Казакова Валерия Дмитриевна")
                .setUniversityId("U001")
                .setCurrentCourseNumber(2)
                .setAvgExamScore(4.7f);
        System.out.println(student2);
    }
}