package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import classes.Usuario;
import dao.ManagerUsuarios;

@WebServlet("/api/usuarios")
public class RegistroUsuarioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        JSONObject body = new JSONObject(req.getReader().lines().reduce("", String::concat));
        Usuario u = ManagerUsuarios.crearUsuario(
            body.getString("nombre"),
            body.getString("correo"),
            body.getString("password")
        );
        JSONObject out = new JSONObject();
        out.put("id", u.getId());
        out.put("nombre", u.getNombre());
        out.put("correo", u.getCorreo());
        out.put("tema", u.getTema());
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(out.toString());
    }
}