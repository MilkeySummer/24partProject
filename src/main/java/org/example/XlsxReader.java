package org.example;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XlsxReader {
    private XlsxReader() {
    }

    public static List<University> readUniversities(String filePath, String sheetName) {
        List<University> universities = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            Iterator<Row> iterator = sheet.iterator();
            if (iterator.hasNext()) {
                iterator.next(); // пропуск заголовка
            }
            while (iterator.hasNext()) {
                Row row = iterator.next();

                String id = row.getCell(0).getStringCellValue();
                String fullName = row.getCell(1).getStringCellValue();
                String shortName = row.getCell(2).getStringCellValue();
                int year = (int) row.getCell(3).getNumericCellValue();
                String profileStr = row.getCell(4).getStringCellValue();

                StudyProfile profile = StudyProfile.valueOf(profileStr);

                University university = new University()
                        .setId(id)
                        .setFullName(fullName)
                        .setShortName(shortName)
                        .setYearOfFoundation(year)
                        .setMainProfile(profile);

                universities.add(university);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return universities;
    }

    public static List<Student> readStudents(String filePath, String sheetName) {
        List<Student> students = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            Iterator<Row> iterator = sheet.iterator();
            if (iterator.hasNext()) {
                iterator.next(); // пропуск заголовка
            }
            while (iterator.hasNext()) {
                Row row = iterator.next();


                String fullName = row.getCell(1).getStringCellValue();
                String universityId = row.getCell(0).getStringCellValue();
                int currentCourseNumber =(int) row.getCell(2).getNumericCellValue();
                float avgExamScore = (float) row.getCell(3).getNumericCellValue();

                Student student = new Student()
                        .setFullName(fullName)
                        .setUniversityId(universityId)
                        .setCurrentCourseNumber(currentCourseNumber)
                        .setAvgExamScore(avgExamScore);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
