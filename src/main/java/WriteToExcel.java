
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToExcel {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private Integer rowNum = 0;


    public void createExcel() {


        try (FileOutputStream outputStream = new FileOutputStream("src/main/resources/MyExcel.xlsx")) {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("sheet");
            XSSFRow row = sheet.createRow(0);
            row.createCell(0).setCellValue("№");
            row.createCell(0).setCellValue("FirstName");
            row.createCell(1).setCellValue("Username");
            row.createCell(2).setCellValue("UserId");
            workbook.write(outputStream);
            workbook.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void write(Message message) {
        try (FileOutputStream outputStream = new FileOutputStream("src/main/resources/MyExcel.xlsx")) {

            Contact contact = message.getContact();

            int r = rowNum + 1;
            XSSFRow row = sheet.createRow(r);
            row.createCell(0).setCellValue(r);
            row.createCell(1).setCellValue(contact.getFirstName());
            row.createCell(2).setCellValue(message.getChat().getUserName());
            row.createCell(3).setCellValue(contact.getUserId());
            workbook.write(outputStream);
            workbook.close();
            rowNum++;


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
