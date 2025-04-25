package dao;

import java.util.*;

public class ManagerCompartirGastos {
    // Mapa gastoId -> lista de usuarios con quienes se compartió
    private static final Map<Long, List<Long>> sharedMap = new HashMap<>();

    public static void compartirGasto(Long gastoId, List<Long> usuarios) {
        sharedMap.put(gastoId, new ArrayList<>(usuarios));
    }

    public static List<Long> obtenerUsuariosCompartidos(Long gastoId) {
        return sharedMap.getOrDefault(gastoId, Collections.emptyList());
    }
}