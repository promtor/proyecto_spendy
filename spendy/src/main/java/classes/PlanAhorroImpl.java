package classes;

import java.math.BigDecimal;
import java.util.Date;

public class PlanAhorroImpl implements PlanAhorro {
    private Long id;
    private Long usuarioId;
    private String nombre;
    private String descripcion;
    private BigDecimal metaImporte;
    private Date fechaInicio;
    private Date fechaFin;

    public PlanAhorroImpl() {
    }

    public PlanAhorroImpl(Long id, Long usuarioId, String nombre, String descripcion,
            BigDecimal metaImporte, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.metaImporte = metaImporte;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public BigDecimal getMetaImporte() {
        return metaImporte;
    }

    @Override
    public void setMetaImporte(BigDecimal metaImporte) {
        this.metaImporte = metaImporte;
    }

    @Override
    public Date getFechaInicio() {
        return fechaInicio;
    }

    @Override
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public Date getFechaFin() {
        return fechaFin;
    }

    @Override
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
