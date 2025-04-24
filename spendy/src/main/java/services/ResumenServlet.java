package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
//import classes.Gasto;
//import classes.Ingreso;
import dao.ManagerGastos;
import dao.ManagerIngresos;

@WebServlet("/api/resumen")
public class ResumenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        double totalG = ManagerGastos.obtenerGastos().stream()
            .mapToDouble(g -> g.getImporte().doubleValue()).sum();
        double totalI = ManagerIngresos.obtenerIngresos().stream()
            .mapToDouble(i -> i.getImporte().doubleValue()).sum();
        JSONObject out = new JSONObject()
            .put("gastos", totalG)
            .put("ingresos", totalI)
            .put("balance", totalI - totalG);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(out.toString());
    }
}