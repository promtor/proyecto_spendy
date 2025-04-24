// Archivo: src/main/java/dao/ManagerGastos.java
package dao;

import classes.Gasto;
import classes.GastoImpl;
import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

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
        Double latitud = body.optDouble("latitud", 0);
        Double longitud = body.optDouble("longitud", 0);

        GastoImpl g = new GastoImpl(
            id, usuarioId, fecha, importe,
            categoriaId, descripcion, latitud, longitud
        );
        gastos.add(g);
        return g;
    }

    public static List<Gasto> obtenerGastos() {
        return new ArrayList<>(gastos);
    }

    public static List<Gasto> obtenerGastosPorUsuario(Long usuarioId) {
        return gastos.stream()
            .filter(g -> g.getUsuarioId().equals(usuarioId))
            .collect(Collectors.toList());
    }

    public static List<Gasto> buscarGastos(String q) {
        String lower = q.toLowerCase();
        return gastos.stream()
            .filter(g -> g.getDescripcion().toLowerCase().contains(lower))
            .collect(Collectors.toList());
    }

    public static List<Gasto> filtrarGastos(JSONObject filtros) {
        Date desde = filtros.has("desde") ? Date.valueOf(filtros.getString("desde")) : null;
        Date hasta = filtros.has("hasta") ? Date.valueOf(filtros.getString("hasta")) : null;
        BigDecimal min = filtros.has("min") ? BigDecimal.valueOf(filtros.getDouble("min")) : null;
        BigDecimal max = filtros.has("max") ? BigDecimal.valueOf(filtros.getDouble("max")) : null;
        Long cat = filtros.has("categoria") ? filtros.getLong("categoria") : null;

        return gastos.stream().filter(g -> {
            if (desde != null && g.getFecha().before(desde)) return false;
            if (hasta != null && g.getFecha().after(hasta)) return false;
            if (min != null && g.getImporte().compareTo(min) < 0) return false;
            if (max != null && g.getImporte().compareTo(max) > 0) return false;
            if (cat != null && !g.getCategoriaId().equals(cat)) return false;
            return true;
        }).collect(Collectors.toList());
    }

    public static JSONObject datosGraficoMensual(Long usuarioId) {
        List<Gasto> lista = obtenerGastosPorUsuario(usuarioId);
        Map<String, BigDecimal> acc = lista.stream()
            .collect(Collectors.groupingBy(
                g -> ((Date)g.getFecha()).toLocalDate()
                         .format(DateTimeFormatter.ofPattern("yyyy-MM")),
                TreeMap::new,
                Collectors.reducing(BigDecimal.ZERO, Gasto::getImporte, BigDecimal::add)
            ));

        JSONObject out = new JSONObject();
        acc.forEach(out::put);
        return out;
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
