package org.example;

public enum UniversityComparators {
    UniversityFullNameComparator("Полное название университета"),
    UniversityIdComparator("Айди университета"),
    UniversityMainProfileComparator("Профиль обучения"),
    UniversityShortNameComparator("Краткое название университета"),
    UniversityYearOfFoundationComparator( "Возраст Университета");

    private final String UniversityComparatorName;

    UniversityComparators(String UniversityComparatorName){
        this.UniversityComparatorName = UniversityComparatorName;
    }
    public String getUniversityComparatorName(){
        return UniversityComparatorName;
    }
}

