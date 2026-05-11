package org.example;

public class ComparatorUtil {
    private ComparatorUtil(){}

    public static StudentComparator getStudentComparator(StudentComparators type){
        switch (type){
            case StudentAvgExamScoreComparator:
                return new StudentAvgExamScoreComparator();
            case StudentCurrentCourseNumberComparator:
                return new StudentCurrentCourseNumberComparator();
            case StudentFullNameComparator:
                return new StudentFullNameComparator();
            case StudentUniversityIdComparator:
                return new StudentUniversityIdComparator();
            default:
                return null;
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparators type){
        switch (type){
            case UniversityFullNameComparator:
                return new UniversityFullNameComparator();
            case UniversityIdComparator:
                return new UniversityIdComparator();
            case UniversityMainProfileComparator:
                return new UniversityMainProfileComparator();
            case UniversityShortNameComparator:
                return new UniversityShortNameComparator();
            case UniversityYearOfFoundationComparator:
                return new UniversityYearOfFoundationComparator();
            default:
                return null;
        }
    }
}
