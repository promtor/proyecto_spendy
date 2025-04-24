package services;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import classes.Gasto;
import dao.ManagerGastos;

@WebServlet("/api/gastos/buscar")
public class BuscarGastosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String q = req.getParameter("q");
        List<Gasto> res = ManagerGastos.buscarGastos(q);
        JSONArray arr = new JSONArray(res);
        JSONObject out = new JSONObject().put("resultados", arr);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(out.toString());
    }
}