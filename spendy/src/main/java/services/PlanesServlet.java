package services;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.json.JSONArray;
import dao.ManagerPlanAhorro;
import dao.ManagerUsuarios;

@WebServlet("/api/planes")
public class PlanesServlet extends HttpServlet {
    private Long authenticate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String auth = req.getHeader("Authorization");
        if (auth == null || !auth.startsWith("Bearer ")) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token faltante"); return null;
        }
        Long userId = ManagerUsuarios.getUserIdFromToken(auth.substring(7));
        if (userId == null) { resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido"); }
        return userId;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = authenticate(req, resp); if (userId==null) return;
        List<?> planes = ManagerPlanAhorro.obtenerPlanesPorUsuario(userId);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(new JSONArray(planes).toString());
    }
}