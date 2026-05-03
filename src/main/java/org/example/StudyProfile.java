package org.example;

public enum StudyProfile {
    MEDICINE("Медицина"),
    PHYSICS("Физика"),
    LINGUISTICS("Лингвисты"),
    MATHEMATICS( "Математики");


    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
