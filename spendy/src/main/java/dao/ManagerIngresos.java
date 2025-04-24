package dao;

import classes.Ingreso;
import classes.IngresoImpl;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ManagerIngresos {
    private static final List<Ingreso> ingresos = new ArrayList<>();
    private static final AtomicLong seqId = new AtomicLong(1);

    public static Ingreso crearIngreso(JSONObject body) {
        Long id = seqId.getAndIncrement();
        Long usuarioId = body.getLong("usuarioId");
        Date fecha = Date.valueOf(body.getString("fecha"));
        BigDecimal importe = BigDecimal.valueOf(body.getDouble("importe"));
        String descripcion = body.getString("descripcion");
        String fuente = body.getString("fuente");
        IngresoImpl i = new IngresoImpl(id, usuarioId, fecha, importe, descripcion, fuente);
        ingresos.add(i);
        return i;
    }

    public static List<Ingreso> obtenerIngresos() {
        return new ArrayList<>(ingresos);
    }
}