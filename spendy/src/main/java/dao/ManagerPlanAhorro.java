package dao;

import classes.PlanAhorro;
import classes.PlanAhorroImpl;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class ManagerPlanAhorro {
    private static final List<PlanAhorro> planes = new ArrayList<>();
    private static final AtomicLong seqId = new AtomicLong(1);

    /**
     * Crea un plan de ahorro para un usuario.
     * JSON debe incluir: usuarioId, nombre, descripcion, metaImporte, fechaInicio, fechaFin
     */
    public static PlanAhorro crearPlan(JSONObject body) {
        Long id = seqId.getAndIncrement();
        Long usuarioId = body.getLong("usuarioId");
        String nombre = body.getString("nombre");
        String descripcion = body.getString("descripcion");
        BigDecimal meta = BigDecimal.valueOf(body.getDouble("metaImporte"));
        Date inicio = Date.valueOf(body.getString("fechaInicio"));
        Date fin = Date.valueOf(body.getString("fechaFin"));

        PlanAhorroImpl p = new PlanAhorroImpl(id, usuarioId, nombre, descripcion, meta, inicio, fin);
        planes.add(p);
        return p;
    }

    /**
     * Devuelve todos los planes.
     */
    public static List<PlanAhorro> obtenerPlanes() {
        return new ArrayList<>(planes);
    }

    /**
     * Devuelve los planes de un usuario.
     */
    public static List<PlanAhorro> obtenerPlanesPorUsuario(Long usuarioId) {
        return planes.stream()
            .filter(p -> p.getUsuarioId().equals(usuarioId))
            .collect(Collectors.toList());
    }
}