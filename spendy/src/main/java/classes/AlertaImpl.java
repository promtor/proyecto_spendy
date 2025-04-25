package classes;

public class AlertaImpl implements Alerta {
    private Long id;
    private Long usuarioId;
    private String mensaje;

    public AlertaImpl() {}

    public AlertaImpl(Long id, Long usuarioId, String mensaje) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.mensaje = mensaje;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getUsuarioId() {
        return usuarioId;
    }

    @Override
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
