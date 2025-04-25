package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.json.JSONObject;
import dao.ManagerRecuperar;

@WebServlet("/api/recuperar")
public class RecuperarPasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        JSONObject body = new JSONObject(req.getReader().lines().reduce("",String::concat));
        String correo = body.getString("correo");
        String token = ManagerRecuperar.generarToken(correo);
        ManagerRecuperar.enviarEmail(correo, token);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(new JSONObject().put("enviado", true).toString());
    }
}
