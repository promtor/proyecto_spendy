package dao;

import classes.Usuario;
import classes.UsuarioImpl;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ManagerUsuarios {
    private static final Map<Long, UsuarioImpl> usuarios = new HashMap<>();
    private static final Map<String, Long> tokenMap = new HashMap<>();
    private static long seqId = 1;

    /**
     * Crea un usuario y lo almacena en memoria con tema por defecto y límite a cero.
     */
    public static Usuario crearUsuario(String nombre, String correo, String passwordHash) {
        UsuarioImpl u = new UsuarioImpl(
            seqId++, nombre, correo, passwordHash,
            "claro", BigDecimal.ZERO
        );
        usuarios.put(u.getId(), u);
        return u;
    }

    /**
     * Valida credenciales y devuelve un token aleatorio si es correcto.
     */
    public static String login(String correo, String passwordHash) {
        for (Usuario u : usuarios.values()) {
            if (u.getCorreo().equals(correo) && u.getPasswordHash().equals(passwordHash)) {
                String token = UUID.randomUUID().toString();
                tokenMap.put(token, u.getId());
                return token;
            }
        }
        return null;
    }

    /**
     * Obtiene el userId asociado a un token.
     */
    public static Long getUserIdFromToken(String token) {
        return tokenMap.get(token);
    }

    /**
     * Recupera un usuario por ID.
     */
    public static Usuario obtenerUsuario(Long id) {
        return usuarios.get(id);
    }

    /**
     * Devuelve el mapa de todos los usuarios.
     */
    public static Map<Long, UsuarioImpl> obtenerTodosLosUsuarios() {
        return usuarios;
    }
}
