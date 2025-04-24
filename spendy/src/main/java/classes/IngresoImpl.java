package classes;

import java.util.Date;
import java.math.BigDecimal;

public class IngresoImpl implements Ingreso {
    private Long id;
    private Long usuarioId;
    private Date fecha;
    private BigDecimal importe;
    private String descripcion;
    private String fuente;

    public IngresoImpl() {
    }

    public IngresoImpl(Long id, Long usuarioId, Date fecha, BigDecimal importe,
            String descripcion, String fuente) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.fecha = fecha;
        this.importe = importe;
        this.descripcion = descripcion;
        this.fuente = fuente;
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
    public Date getFecha() {
        return fecha;
    }

    @Override
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public BigDecimal getImporte() {
        return importe;
    }

    @Override
    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String getFuente() {
        return fuente;
    }

    @Override
    public void setFuente(String fuente) {
        this.fuente = fuente;
    }
}
