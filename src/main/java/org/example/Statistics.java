package org.example;
import java.util.List;

public class Statistics {
    private StudyProfile profile;
    private float avgExamScore;
    private int quantityStudents;
    private int quantityUniversities;
    private List<String> universityNames;

    public Statistics(StudyProfile profile, float avgExamScore, int quantityStudents, int quantityUniversities, List<String> universityNames) {
        this.profile = profile;
        this.avgExamScore = avgExamScore;
        this.quantityStudents = quantityStudents;
        this.quantityUniversities = quantityUniversities;
        this.universityNames = universityNames;
    }

    public StudyProfile getProfile() {
        return profile;
    }

    public void setProfile(StudyProfile profile) {
        this.profile = profile;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public int getQuantityStudents() {
        return quantityStudents;
    }

    public void setQuantityStudents(int quantityStudents) {
        this.quantityStudents = quantityStudents;
    }

    public int getQuantityUniversities() {
        return quantityUniversities;
    }

    public void setQuantityUniversities(int quantityUniversities) {
        this.quantityUniversities = quantityUniversities;
    }

    public List<String> getUniversityNames() {
        return universityNames;
    }

    public void setUniversityNames(List<String> universityNames) {
        this.universityNames = universityNames;
    }
}
