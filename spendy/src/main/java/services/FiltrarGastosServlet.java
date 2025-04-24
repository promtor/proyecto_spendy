package services;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import classes.Gasto;
import dao.ManagerGastos;

@WebServlet("/api/gastos/filtro")
public class FiltrarGastosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        JSONObject filtros = new JSONObject();
        for (Map.Entry<String, String[]> e : req.getParameterMap().entrySet()) {
            filtros.put(e.getKey(), e.getValue()[0]);
        }
        java.util.List<Gasto> res = ManagerGastos.filtrarGastos(filtros);
        JSONArray arr = new JSONArray(res);
        JSONObject out = new JSONObject().put("gastos", arr);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(out.toString());
    }
}