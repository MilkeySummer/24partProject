package org.example;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {
    public void setProcessedAt(String processedAt) {
        this.processedAt = processedAt;
    }

    public void setStatisticalInfo(List<StatisticsEntry> statisticalInfo) {
        this.statisticalInfo = statisticalInfo;
    }

    public void setUniversitiesInfo(List<UniversityEntry> universitiesInfo) {
        this.universitiesInfo = universitiesInfo;
    }

    public void setStudentsInfo(List<StudentEntry> studentsInfo) {
        this.studentsInfo = studentsInfo;
    }

    public String getProcessedAt() {
        return processedAt;
    }

    public List<StatisticsEntry> getStatisticalInfo() {
        return statisticalInfo;
    }

    public List<UniversityEntry> getUniversitiesInfo() {
        return universitiesInfo;
    }

    public List<StudentEntry> getStudentsInfo() {
        return studentsInfo;
    }

    @XmlElementWrapper(name = "studentsInfo")
    @XmlElement(name = "studentEntry")
    private List<StudentEntry> studentsInfo;

    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universityEntry")
    private List<UniversityEntry> universitiesInfo;

    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    private List<StatisticsEntry> statisticalInfo;

    @XmlElement(name = "processedAt")
    private String processedAt;
}
