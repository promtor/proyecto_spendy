package dao;

import classes.Gasto;
import classes.GastoImpl;
import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ManagerGastos {
    private static final List<Gasto> gastos = new ArrayList<>();
    private static final AtomicLong seqId = new AtomicLong(1);

    public static Gasto crearGasto(JSONObject body) {
        Long id = seqId.getAndIncrement();
        Long usuarioId = body.getLong("usuarioId");
        Date fecha = Date.valueOf(body.getString("fecha"));
        BigDecimal importe = BigDecimal.valueOf(body.getDouble("importe"));
        Long categoriaId = body.getLong("categoriaId");
        String descripcion = body.getString("descripcion");
        Double lat = body.optDouble("latitud", 0);
        Double lon = body.optDouble("longitud", 0);
        GastoImpl g = new GastoImpl(id, usuarioId, fecha, importe, categoriaId, descripcion, lat, lon);
        gastos.add(g);
        return g;
    }

    public static List<Gasto> obtenerGastos() {
        return new ArrayList<>(gastos);
    }

    public static List<Gasto> buscarGastos(String q) {
        List<Gasto> res = new ArrayList<>();
        for (Gasto g : gastos) {
            if (g.getDescripcion().toLowerCase().contains(q.toLowerCase())) res.add(g);
        }
        return res;
    }

    public static List<Gasto> filtrarGastos(JSONObject filtros) {
        // TODO: filtrar por fecha, importe y categoría
        return obtenerGastos();
    }

    public static JSONObject datosGraficoMensual() {
        // TODO: agrupa por mes
        return new JSONObject();
    }

    public static JSONArray obtenerUbicaciones() {
        JSONArray arr = new JSONArray();
        for (Gasto g : gastos) {
            JSONObject o = new JSONObject();
            o.put("latitud", g.getLatitud());
            o.put("longitud", g.getLongitud());
            arr.put(o);
        }
        return arr;
    }
}