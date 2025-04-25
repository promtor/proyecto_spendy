package classes;

public interface Alerta {
    Long getId();
    void setId(Long id);
    Long getUsuarioId();
    void setUsuarioId(Long usuarioId);
    String getMensaje();
    void setMensaje(String mensaje);
}