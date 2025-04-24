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

    /**
     * Obtiene solo los gastos de un usuario.
     */
    public static List<Gasto> obtenerGastosPorUsuario(Long usuarioId) {
        List<Gasto> res = new ArrayList<>();
        for (Gasto g : gastos) {
            if (g.getUsuarioId().equals(usuarioId)) {
                res.add(g);
            }
        }
        return res;
    }

    public static List<Gasto> buscarGastos(String q) {
        List<Gasto> res = new ArrayList<>();
        for (Gasto g : gastos) {
            if (g.getDescripcion().toLowerCase().contains(q.toLowerCase())) res.add(g);
        }
        return res;
    }

        /**
     * Filtra gastos según parámetros: desde, hasta, min, max, categoria
     */
    public static List<Gasto> filtrarGastos(JSONObject filtros) {
        List<Gasto> res = new ArrayList<>();
        Date fechaDesde = null, fechaHasta = null;
        BigDecimal minImporte = null, maxImporte = null;
        Long catId = null;
        // Parseo de filtros si están presentes
        if (filtros.has("desde")) {
            fechaDesde = Date.valueOf(filtros.getString("desde"));
        }
        if (filtros.has("hasta")) {
            fechaHasta = Date.valueOf(filtros.getString("hasta"));
        }
        if (filtros.has("min")) {
            minImporte = BigDecimal.valueOf(filtros.getDouble("min"));
        }
        if (filtros.has("max")) {
            maxImporte = BigDecimal.valueOf(filtros.getDouble("max"));
        }
        if (filtros.has("categoria")) {
            catId = filtros.getLong("categoria");
        }
        // Filtrado
        for (Gasto g : gastos) {
            boolean ok = true;
            if (fechaDesde != null && g.getFecha().before(fechaDesde)) {
                ok = false;
            }
            if (fechaHasta != null && g.getFecha().after(fechaHasta)) {
                ok = false;
            }
            if (minImporte != null && g.getImporte().compareTo(minImporte) < 0) {
                ok = false;
            }
            if (maxImporte != null && g.getImporte().compareTo(maxImporte) > 0) {
                ok = false;
            }
            if (catId != null && !g.getCategoriaId().equals(catId)) {
                ok = false;
            }
            if (ok) {
                res.add(g);
            }
        }
        return res;
    }public static JSONObject datosGraficoMensual() {
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
