package dao;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ManagerRecuperar {
    private static final Map<String, String> recoveryTokens = new HashMap<>();

    /**
     * Genera y almacena un token de recuperación para un correo.
     */
    public static String generarToken(String correo) {
        String token = UUID.randomUUID().toString();
        recoveryTokens.put(correo, token);
        return token;
    }

    /**
     * Valida el token para un correo.
     */
    public static boolean validarToken(String correo, String token) {
        return token.equals(recoveryTokens.get(correo));
    }

    /**
     * Envía (simulado) un correo de recuperación.
     */
    public static void enviarEmail(String correo, String token) {
        System.out.println("Simulación de envío de email a " + correo + " con token " + token);
    }
}