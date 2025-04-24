package dao;

import classes.Usuario;
import classes.UsuarioImpl;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ManagerUsuarios {
    private static final Map<Long, UsuarioImpl> usuarios = new HashMap<>();
    private static long seqId = 1;

    public static Usuario crearUsuario(String nombre, String correo, String passwordHash) {
        UsuarioImpl u = new UsuarioImpl(
            seqId++, nombre, correo, passwordHash,
            "claro", BigDecimal.ZERO
        );
        usuarios.put(u.getId(), u);
        return u;
    }

    public static String login(String correo, String passwordHash) {
        for (Usuario u : usuarios.values()) {
            if (u.getCorreo().equals(correo) && u.getPasswordHash().equals(passwordHash)) {
                return UUID.randomUUID().toString();
            }
        }
        return null;
    }

    public static Usuario obtenerUsuario(Long id) {
        return usuarios.get(id);
    }

    public static Map<Long, UsuarioImpl> obtenerTodosLosUsuarios() {
        return usuarios;
    }
}