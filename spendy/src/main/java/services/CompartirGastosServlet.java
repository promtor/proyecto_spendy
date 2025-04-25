package services;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.json.JSONArray;
import org.json.JSONObject;
import dao.ManagerCompartirGastos;
import dao.ManagerUsuarios;

@WebServlet("/api/gastos/compartir")
public class CompartirGastosServlet extends HttpServlet {
    private Long authenticate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String auth = req.getHeader("Authorization");
        if (auth==null||!auth.startsWith("Bearer ")) { resp.sendError(401); return null; }
        Long userId = ManagerUsuarios.getUserIdFromToken(auth.substring(7));
        if (userId==null) { resp.sendError(401); }
        return userId;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = authenticate(req, resp); if(userId==null) return;
        JSONObject body = new JSONObject(req.getReader().lines().reduce("",String::concat));
        Long gastoId = body.getLong("gastoId");
        JSONArray arr = body.getJSONArray("usuarios");
        List<Long> usuarios = new ArrayList<>();
        for(Object o: arr) usuarios.add(((Number)o).longValue());
        ManagerCompartirGastos.compartirGasto(gastoId, usuarios);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(new JSONObject().put("ok",true).toString());
    }
}