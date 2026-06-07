package org.example;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class StudentEntry {
    @XmlElement(name = "studentName")
    private String studentName;
    @XmlElement(name = "universityId")
    private String universityId;
    @XmlElement(name = "avgScore")
    private float avgScore;

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public String getUniversityId() {
        return universityId;
    }

    public String getStudentName() {
        return studentName;
    }
}
