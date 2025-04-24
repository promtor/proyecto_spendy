package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import dao.ManagerGastos;

@WebServlet("/api/graficos")
public class GraficosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        JSONObject datos = ManagerGastos.datosGraficoMensual();
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(datos.toString());
    }
}