package classes;

import java.util.Date;
import java.math.BigDecimal;

public interface Ingreso {
    Long getId();

    void setId(Long id);

    Long getUsuarioId();

    void setUsuarioId(Long usuarioId);

    Date getFecha();

    void setFecha(Date fecha);

    BigDecimal getImporte();

    void setImporte(BigDecimal importe);

    String getDescripcion();

    void setDescripcion(String descripcion);

    String getFuente();

    void setFuente(String fuente);
}
