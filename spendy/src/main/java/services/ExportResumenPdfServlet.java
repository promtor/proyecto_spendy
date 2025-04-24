package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dao.ManagerGastos;
import dao.ManagerIngresos;

@WebServlet("/exportResumenPdf")
public class ExportResumenPdfServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 1. Recuperar los datos
        double totalGastos = ManagerGastos.obtenerGastos().stream()
            .mapToDouble(g -> g.getImporte().doubleValue()).sum();
        double totalIngresos = ManagerIngresos.obtenerIngresos().stream()
            .mapToDouble(i -> i.getImporte().doubleValue()).sum();
        double balance = totalIngresos - totalGastos;

        // 2. Configurar la respuesta para PDF
        resp.setContentType("application/pdf");
        resp.setHeader("Content-Disposition", "attachment; filename=\"resumen.pdf\"");

        // 3. Generar el PDF
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, resp.getOutputStream());
            document.open();

            document.add(new Paragraph("Resumen de Gastos e Ingresos"));
            document.add(new Paragraph(" ")); // línea en blanco

            PdfPTable table = new PdfPTable(2);
            table.setWidths(new float[]{3, 2});
            table.addCell("Concepto");
            table.addCell("Importe");
            table.addCell("Total Gastos");
            table.addCell(String.format("%.2f €", totalGastos));
            table.addCell("Total Ingresos");
            table.addCell(String.format("%.2f €", totalIngresos));
            table.addCell("Balance");
            table.addCell(String.format("%.2f €", balance));

            document.add(table);
        } catch (DocumentException e) {
            throw new IOException(e);
        } finally {
            document.close();
        }
    }
}
