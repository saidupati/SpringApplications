package com.ojas.generate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.ojas.model.Product;

public class GeneraterPDF {



	public static boolean GeneratePdf(List<Product> product) {
		boolean flag = false;
		try {
			// Create Document instance.
			Document document = new Document();

			// Create OutputStream instance.
			FileOutputStream outputStream = new FileOutputStream(new File("C:\\Users\\sd22279\\Documents\\pdf\\product.pdf"));

			// Create PDFWriter instance.
			PdfWriter.getInstance(document, outputStream);

			// Open the document.
			document.open();

			// Add content to the document.
			product.stream().forEach(u -> {
				try {
					document.add(new Paragraph(u.getPid() + "\t" + u.getPname() + "\t" + u.getPprice()
							));
				} catch (DocumentException e) {
					e.printStackTrace();
				}

			});
			document.add(new Paragraph("Hello world, " + "this is a test pdf file."));

			// Close document and outputStream.
			document.close();
			outputStream.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}

