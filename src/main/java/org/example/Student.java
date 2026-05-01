package org.example;

public class Student {
    private String fullName;
    private String universityId;
    private int currentCourseNumber;
    private float avgExamScore;

    public Student() {
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public String getUniversityId() {
        return universityId;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public Student setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public String toString(){
        return "Student{ " + "fullName = " + fullName + " ,universityId = " + universityId +
                " ,currentCourseNumber = " + currentCourseNumber + " ,avgExamScore" + avgExamScore + "}";
    }
}
