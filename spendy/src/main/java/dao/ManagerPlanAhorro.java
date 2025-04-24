package dao;

import classes.PlanAhorro;
import classes.PlanAhorroImpl;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ManagerPlanAhorro {
    private static final List<PlanAhorro> planes = new ArrayList<>();
    private static final AtomicLong seqId = new AtomicLong(1);

    public static PlanAhorro crearPlan(JSONObject body) {
        Long id = seqId.getAndIncrement();
        PlanAhorroImpl p = new PlanAhorroImpl(
            id,
            body.getLong("usuarioId"),
            body.getString("nombre"),
            body.getString("descripcion"),
            BigDecimal.valueOf(body.getDouble("metaImporte")),
            Date.valueOf(body.getString("fechaInicio")),
            Date.valueOf(body.getString("fechaFin"))
        );
        planes.add(p);
        return p;
    }

    public static List<PlanAhorro> obtenerPlanes() {
        return new ArrayList<>(planes);
    }
}