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

@WebServlet(urlPatterns = {"/api/gastos"})
public class GastoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        JSONObject body = new JSONObject(req.getReader().lines().reduce("", String::concat));
        Gasto g = ManagerGastos.crearGasto(body);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(new JSONObject(g).toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Gasto> list = ManagerGastos.obtenerGastos();
        JSONArray arr = new JSONArray(list);
        JSONObject out = new JSONObject().put("gastos", arr);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(out.toString());
    }
}