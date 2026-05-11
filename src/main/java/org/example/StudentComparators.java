package org.example;

public enum StudentComparators {
    StudentAvgExamScoreComparator("Средний балл студента"),
    StudentCurrentCourseNumberComparator("Курс студента"),
    StudentFullNameComparator("Полное имя студента"),
    StudentUniversityIdComparator( "Айди универа студента");

    private final String StudentComparatorName;

    StudentComparators(String StudentComparatorName){
        this.StudentComparatorName = StudentComparatorName;
    }

    public String getStudentComparatorName(){
        return StudentComparatorName;
    }
}
