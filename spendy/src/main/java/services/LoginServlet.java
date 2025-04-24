package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import dao.ManagerUsuarios;

@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        JSONObject body = new JSONObject(req.getReader().lines().reduce("", String::concat));
        String token = ManagerUsuarios.login(
            body.getString("correo"),
            body.getString("password")
        );
        JSONObject out = new JSONObject();
        if (token != null) {
            out.put("token", token);
        } else {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            out.put("error", "Credenciales inválidas");
        }
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(out.toString());
    }
}
