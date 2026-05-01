package org.example;

public class University {
    private String id;
    private String fullName;
    private String shortName;
    private int yearOfFoundation;
    private StudyProfile mainProfile;

    public University() {
    }

    public University setId(String id) {
        this.id = id;
        return  this;
    }

    public String getId() {
        return id;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public String toString(){
        return "University{ " + "id = " + id + " ,fullName = " + fullName + " ,shortName = " + shortName +
                " ,yearOfFoundation = " + yearOfFoundation + " ,mainProfile" + mainProfile + "}";
    }
}
