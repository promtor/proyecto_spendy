package classes;

import java.math.BigDecimal;
import java.util.Date;

public interface PlanAhorro {
    Long getId();

    void setId(Long id);

    Long getUsuarioId();

    void setUsuarioId(Long usuarioId);

    String getNombre();

    void setNombre(String nombre);

    String getDescripcion();

    void setDescripcion(String descripcion);

    BigDecimal getMetaImporte();

    void setMetaImporte(BigDecimal metaImporte);

    Date getFechaInicio();

    void setFechaInicio(Date fechaInicio);

    Date getFechaFin();

    void setFechaFin(Date fechaFin);
}
