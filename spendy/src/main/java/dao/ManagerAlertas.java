package dao;

//import dao.ManagerUsuarios;
//import dao.ManagerGastos;
import org.json.JSONArray;
import org.json.JSONObject;

//import java.util.List;

public class ManagerAlertas {
    /**
     * Genera alertas para usuarios que superen su límite mensual.
     */
    public static JSONArray obtenerAlertas() {
        JSONArray arr = new JSONArray();
        // para cada usuario, suma gastos y compara con límite
        ManagerUsuarios.obtenerTodosLosUsuarios().values().forEach(u -> {
            double totalG = ManagerGastos.obtenerGastos().stream()
                .filter(g -> g.getUsuarioId().equals(u.getId()))
                .mapToDouble(g -> g.getImporte().doubleValue())
                .sum();
            if (u.getLimiteMensual().doubleValue() > 0 && totalG > u.getLimiteMensual().doubleValue()) {
                JSONObject o = new JSONObject();
                o.put("usuarioId", u.getId());
                o.put("message", "Has superado tu límite mensual");
                arr.put(o);
            }
        });
        return arr;
    }
}