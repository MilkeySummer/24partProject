package org.example;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class StatisticsEntry {
    @XmlElement(name = "universityProfile")
    private String universityProfile;

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }

    public void setUniversityProfile(String universityProfile) {
        this.universityProfile = universityProfile;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public String getUniversityProfile() {
        return universityProfile;
    }

    @XmlElement(name = "avgScore")
    private float avgScore;
}
