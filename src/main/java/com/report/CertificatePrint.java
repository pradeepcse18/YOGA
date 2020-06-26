package com.report;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.modal.Customer;
import com.service.CustomerService;

import java.awt.Color;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CertificatePrint {
	
	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/print", method = RequestMethod.GET, headers = "Accept=application/json")
	public void createPdf( @RequestParam("sirName") String sirName,@RequestParam("name") String name,
			@RequestParam("contact") String contact,@RequestParam("alt_contact") String alt_contact,
			@RequestParam("email") String email,@RequestParam("co_ord") String co_ord,
			@RequestParam("dist") String dist,@RequestParam("state") String state,
			HttpServletRequest request, HttpServletResponse response)throws IOException, DocumentException {
		Customer customer=new Customer();
		customer.setName(sirName+" "+name);
		customer.setMobile(contact);
		customer.setAlt_mobile(alt_contact);
		customer.setEmail(email);
		customer.setCo_ord(co_ord);
		customer.setDistrict(dist);
		customer.setState(state);
		customer.setDate(new Date(System.currentTimeMillis()));
		customerService.addCustomer(customer);
		
		final String IMAGE ="E:\\PRODUCT\\HOME\\DEV\\project\\root\\src\\main\\java\\com\\report\\Certificate.jpg";
		Document d = new Document(PageSize.A4.rotate());
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "attachment; filename=Certificate.pdf");
		ServletOutputStream pusher = response.getOutputStream();
		PdfWriter writer = PdfWriter.getInstance(d, pusher);
		d.open();
		Paragraph paragraph = new Paragraph("  ");
		paragraph.setSpacingAfter(133);
        d.add(paragraph); 
		Paragraph paragraphName = new Paragraph("                                                                                        "+sirName+" "+name ,
				             FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.BOLDITALIC));
		paragraphName.setSpacingAfter(90);
		d.add(paragraphName); 
		Paragraph paragraphAdd = new Paragraph("                                      "+dist+" , "+state,
	             FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.BOLDITALIC));
		paragraphAdd.setAlignment(Paragraph.ALIGN_CENTER);
		d.add(paragraphAdd);
		PdfContentByte canvas = writer.getDirectContentUnder();
		Image image = Image.getInstance(IMAGE);
		image.scaleAbsolute(PageSize.A4.rotate());
		image.setAbsolutePosition(0, 0);
		canvas.addImage(image);
		d.close();
		pusher.close();

	}
}
