package com.ojas.generate;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.ojas.model.Product;


public class GenerateExcel {

	public static boolean excelReport(List<Product> product) {

		HSSFWorkbook workbook = new HSSFWorkbook();

		boolean flag = false;

		try {
			FileOutputStream out = new FileOutputStream(
					new File("C:\\Users\\sd22279\\Documents\\pdf-excel\\userexcel.xls"));

			HSSFSheet sheet = workbook.createSheet("sheet1");
			int rownum = 0;
			for (Product u : product) {
				Row row = sheet.createRow(rownum++);
				Cell cell1 = row.createCell(0);
				Cell cell2 = row.createCell(1);
				Cell cell3 = row.createCell(2);
				Cell cell4 = row.createCell(3);
				Cell cell5 = row.createCell(4);
				cell1.setCellValue((int) u.getPid());
				cell2.setCellValue((String) u.getPname());
				cell3.setCellValue((int) u.getPprice());

			}

			try {
				workbook.write(out);
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Excel Successfully generated");

		return flag;
	}

}