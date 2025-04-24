package dao;

import classes.Usuario;
//import dao.ManagerUsuarios;
import org.json.JSONObject;

public class ManagerConfiguracion {

    /**
     * Actualiza el tema de la configuración del usuario y devuelve
     * un JSONObject con la configuración resultante.
     */
    public static JSONObject actualizarConfiguracion(JSONObject body) {
        Long uid = body.getLong("usuarioId");
        String tema = body.getString("tema");

        // Obtenemos el usuario existente
        Usuario u = ManagerUsuarios.obtenerUsuario(uid);
        if (u != null) {
            // Actualizamos su tema
            u.setTema(tema);

            // Construimos el JSON de respuesta
            JSONObject o = new JSONObject();
            o.put("usuarioId", uid);
            o.put("tema", tema);
            return o;
        }
        return null;
    }
}