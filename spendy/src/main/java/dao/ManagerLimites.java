package dao;

import classes.Limite;
import classes.LimiteImpl;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.ArrayList;

public class ManagerLimites {
    // Map de usuarioId -> Limite
    private static final Map<Long, Limite> limites = new ConcurrentHashMap<>();

    /**
     * Establece o actualiza el límite mensual de un usuario.
     */
    public static Limite establecerLimite(Long usuarioId, BigDecimal valor) {
        Limite l = new LimiteImpl(usuarioId, valor);
        limites.put(usuarioId, l);
        return l;
    }

    /**
     * Obtiene el límite mensual de un usuario específico.
     * Devuelve una lista con el límite si existe, o vacía si no.
     */
    public static List<Limite> obtenerLimitesPorUsuario(Long usuarioId) {
        List<Limite> res = new ArrayList<>();
        Limite l = limites.get(usuarioId);
        if (l != null) {
            res.add(l);
        }
        return res;
    }
}
