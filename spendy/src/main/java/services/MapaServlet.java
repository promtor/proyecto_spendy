// src/main/java/services/MapaServlet.java
package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// IMPORTACIONES NECESARIAS
import org.json.JSONArray;
import org.json.JSONObject;

import dao.ManagerGastos;

@WebServlet("/api/mapa")
public class MapaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Obtenemos el array de ubicaciones desde el DAO
        JSONArray arr = ManagerGastos.obtenerUbicaciones();

        // Creamos el objeto de respuesta
        JSONObject out = new JSONObject();
        out.put("mapa", arr);

        // Escribimos JSON de respuesta
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(out.toString());
    }
}
