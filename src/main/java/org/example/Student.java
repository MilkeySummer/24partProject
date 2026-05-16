package org.example;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("Полное имя")
    private String fullName;
    @SerializedName("ID Университета")
    private String universityId;
    @SerializedName("Номер курса")
    private int currentCourseNumber;
    @SerializedName("Средний балл экзаменов")
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
