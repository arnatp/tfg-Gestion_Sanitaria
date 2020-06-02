package es.institutmarianao.pdf;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import es.institutmarianao.domain.Visit;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * 
 * @author www.codejava.net
 *
 */
public class PDFBuilder extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get data model which is passed by the Spring container
		@SuppressWarnings("unchecked")
		List<Visit> visitList = (List<Visit>) model.get("visits");

		doc.add(new Paragraph("HISTORIAL DE VISITAS"));
		doc.add(new Paragraph("Nombre del paciente: " + visitList.get(0).getPatient().getName()));
		doc.add(new Paragraph("Fecha de impresión: " + LocalDate.now().toString()));

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 1.5f, 2.0f, 3.0f, 3.0f, 2.0f });
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);

		// write table header
		cell.setPhrase(new Phrase("Fecha visita", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Doctor", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Descripción de la visita", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Resolución de la visita", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Nombre Medicamento", font));
		table.addCell(cell);

		for (Visit visit : visitList) {
			table.addCell(visit.getDate().toString());
			table.addCell(visit.getDoctor().getName());
			table.addCell(visit.getInitialDescription());
			table.addCell(visit.getResolution());
			if (visit.getPrescription() != null) {
				table.addCell(visit.getPrescription().getMedicamentName());
			} else {
				table.addCell(" ");
			}
		}

		doc.add(table);

	}

}
