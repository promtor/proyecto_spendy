package dao;

import classes.Alerta;
import classes.AlertaImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class ManagerAlertas {
    // Almacenamiento de alertas en memoria
    private static final List<Alerta> alertas = new ArrayList<>();
    private static final AtomicLong seqId = new AtomicLong(1);

    /**
     * Crea una alerta para un usuario.
     */
    public static Alerta crearAlerta(Long usuarioId, String mensaje) {
        Alerta a = new AlertaImpl(seqId.getAndIncrement(), usuarioId, mensaje);
        alertas.add(a);
        return a;
    }

    /**
     * Obtiene las alertas de un usuario como un JSONArray.
     */
    public static JSONArray obtenerAlertas(Long usuarioId) {
        JSONArray arr = new JSONArray();
        for (Alerta a : alertas) {
            if (a.getUsuarioId().equals(usuarioId)) {
                JSONObject o = new JSONObject();
                o.put("id", a.getId());
                o.put("mensaje", a.getMensaje());
                arr.put(o);
            }
        }
        return arr;
    }
}
