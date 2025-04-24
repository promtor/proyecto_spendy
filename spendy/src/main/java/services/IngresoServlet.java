// src/main/java/services/IngresoServlet.java
package services;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.json.JSONArray;
import org.json.JSONObject;
import classes.Ingreso;
import dao.ManagerIngresos;
import dao.ManagerUsuarios;

@WebServlet("/api/ingresos")
public class IngresoServlet extends HttpServlet {
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

        Ingreso i = ManagerIngresos.crearIngreso(body);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(new JSONObject(i).toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = authenticate(req, resp);
        if (userId == null) return;

        List<Ingreso> l = ManagerIngresos.obtenerIngresosPorUsuario(userId);
        JSONArray arr = new JSONArray(l);
        JSONObject out = new JSONObject().put("ingresos", arr);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(out.toString());
    }
}
