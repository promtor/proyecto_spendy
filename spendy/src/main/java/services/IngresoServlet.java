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
import classes.Ingreso;
import dao.ManagerIngresos;

@WebServlet("/api/ingresos")
public class IngresoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        JSONObject body = new JSONObject(req.getReader().lines().reduce("", String::concat));
        Ingreso i = ManagerIngresos.crearIngreso(body);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(new JSONObject(i).toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Ingreso> l = ManagerIngresos.obtenerIngresos();
        JSONArray arr = new JSONArray(l);
        JSONObject out = new JSONObject().put("ingresos", arr);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(out.toString());
    }
}