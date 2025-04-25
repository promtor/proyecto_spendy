// src/main/java/services/LimitesServlet.java
package services;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.json.JSONArray;
import org.json.JSONObject;

import classes.Limite;
import dao.ManagerLimites;
import dao.ManagerUsuarios;

@WebServlet("/api/limites")
public class LimitesServlet extends HttpServlet {
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
        double valor = body.getDouble("limiteMensual");

        // Establecemos el límite usando ManagerLimites
        Limite l = ManagerLimites.establecerLimite(userId, BigDecimal.valueOf(valor));

        JSONObject out = new JSONObject();
        out.put("usuarioId", l.getUsuarioId());
        out.put("limiteMensual", l.getLimiteMensual());
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(out.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = authenticate(req, resp);
        if (userId == null) return;

        // Obtenemos solo el límite de este usuario
        List<Limite> lista = ManagerLimites.obtenerLimitesPorUsuario(userId);
        JSONArray arr = new JSONArray(lista);

        JSONObject out = new JSONObject();
        out.put("limites", arr);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(out.toString());
    }
}
