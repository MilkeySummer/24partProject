package org.example;

public class StudentAvgExamScoreComparator implements StudentComparator{
    public int compare(Student s1, Student s2){
        return Float.compare(s2.getAvgExamScore(), s1.getAvgExamScore());
    }
}
