package org.example;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class UniversityEntry {
    @XmlElement(name = "universityId")
    private String universityId;
    @XmlElement(name = "universityName")
    private String universityName;

    public void setUniversityProfile(String universityProfile) {
        this.universityProfile = universityProfile;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public String getUniversityProfile() {
        return universityProfile;
    }

    public String getUniversityName() {
        return universityName;
    }

    public String getUniversityId() {
        return universityId;
    }

    @XmlElement(name = "universityProfile")
    private String universityProfile;
}
