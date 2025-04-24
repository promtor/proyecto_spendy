package classes;

import java.util.Date;
import java.math.BigDecimal;

public class GastoImpl implements Gasto {
    private Long id;
    private Long usuarioId;
    private Date fecha;
    private BigDecimal importe;
    private Long categoriaId;
    private String descripcion;
    private Double latitud;
    private Double longitud;

    public GastoImpl() {
    }

    public GastoImpl(Long id, Long usuarioId, Date fecha, BigDecimal importe, Long categoriaId,
            String descripcion, Double latitud, Double longitud) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.fecha = fecha;
        this.importe = importe;
        this.categoriaId = categoriaId;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
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
    public Long getCategoriaId() {
        return categoriaId;
    }

    @Override
    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
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
    public Double getLatitud() {
        return latitud;
    }

    @Override
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    @Override
    public Double getLongitud() {
        return longitud;
    }

    @Override
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
}
