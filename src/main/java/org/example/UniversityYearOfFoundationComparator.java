package org.example;

public class UniversityYearOfFoundationComparator implements UniversityComparator{
    public int compare(University u1, University u2){
        return Integer.compare(u1.getYearOfFoundation(), u2.getYearOfFoundation());
    }
}
