// src/main/java/services/GraficosServlet.java
package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.json.JSONObject;
import dao.ManagerGastos;
import dao.ManagerUsuarios;

@WebServlet("/api/graficos")
public class GraficosServlet extends HttpServlet {
    private Long authenticate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String auth = req.getHeader("Authorization");
        if (auth == null || !auth.startsWith("Bearer ")) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token faltante o inválido");
            return null;
        }
        String token = auth.substring("Bearer ".length());
        Long userId = ManagerUsuarios.getUserIdFromToken(token);
        if (userId == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido");
        }
        return userId;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = authenticate(req, resp);
        if (userId == null) return;

        // PASO CLAVE: le pasamos userId al método
        JSONObject datos = ManagerGastos.datosGraficoMensual(userId);

        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(datos.toString());
    }
}
