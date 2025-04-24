// src/main/java/services/GastoServlet.java
package services;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.json.JSONArray;
import org.json.JSONObject;
import classes.Gasto;
import dao.ManagerGastos;
import dao.ManagerUsuarios;

@WebServlet("/api/gastos")
public class GastoServlet extends HttpServlet {
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = authenticate(req, resp);
        if (userId == null) return;

        JSONObject body = new JSONObject(req.getReader().lines().reduce("", String::concat));
        // Forzamos usuario logueado
        body.put("usuarioId", userId);

        Gasto g = ManagerGastos.crearGasto(body);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(new JSONObject(g).toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = authenticate(req, resp);
        if (userId == null) return;

        List<Gasto> list = ManagerGastos.obtenerGastosPorUsuario(userId);
        JSONArray arr = new JSONArray(list);
        JSONObject out = new JSONObject().put("gastos", arr);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(out.toString());
    }
}
