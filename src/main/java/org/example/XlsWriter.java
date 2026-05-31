package org.example;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {
    private static final Logger logger = Logger.getLogger(XlsWriter.class.getName());
    private XlsWriter() {}
    public static void writeStatistics(List<Statistics> statisticsList, String filePath) {
        logger.info("Начало записи статистики: " + filePath);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Statistics");
        XSSFRow headerRow = sheet.createRow(0);
        XSSFCell cell0 = headerRow.createCell(0);
        cell0.setCellValue("Профиль обучения");

        XSSFCell cell1 = headerRow.createCell(1);
        cell1.setCellValue("Средний балл");

        XSSFCell cell2 = headerRow.createCell(2);
        cell2.setCellValue("Количество студентов по профилю");

        XSSFCell cell3 = headerRow.createCell(3);
        cell3.setCellValue("Количество университетов по профилю");

        XSSFCell cell4 = headerRow.createCell(4);
        cell4.setCellValue("Названия университетов");

        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short)12);
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        cell0.setCellStyle(style);
        cell1.setCellStyle(style);
        cell2.setCellStyle(style);
        cell3.setCellStyle(style);
        cell4.setCellStyle(style);

        int rowNum = 1;
        for (Statistics stat: statisticsList){
            XSSFRow row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(stat.getProfile().getProfileName());
            row.createCell(1).setCellValue(stat.getAvgExamScore());
            row.createCell(2).setCellValue(stat.getQuantityStudents());
            row.createCell(3).setCellValue(stat.getQuantityUniversities());
            String universitiesStr = String.join(", ", stat.getUniversityNames());
            row.createCell(4).setCellValue(universitiesStr);
        }
        try (FileOutputStream fos = new FileOutputStream(filePath))
        {
            workbook.write(fos);
            logger.info("Запись статистики завершена. Записано строк: " + statisticsList.size());
        } catch (IOException e){
            logger.log(Level.SEVERE, "Ошибка записи статистики в Excel", e);
        } finally {
            try {
              workbook.close();
            } catch (IOException e){
                logger.log(Level.SEVERE, "Ошибка закрытия workbook", e);
            }
        }

    }
}
