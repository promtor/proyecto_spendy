package dao;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

public class ManagerExport {
    public static void exportarPDF(HttpServletResponse response) throws IOException {
        // TODO: implementar PDF
        response.setContentType("application/pdf");
    }
}