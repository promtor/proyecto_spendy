package classes;

import java.util.Date;
import java.math.BigDecimal;

public interface Gasto {
    Long getId();

    void setId(Long id);

    Long getUsuarioId();

    void setUsuarioId(Long usuarioId);

    Date getFecha();

    void setFecha(Date fecha);

    BigDecimal getImporte();

    void setImporte(BigDecimal importe);

    Long getCategoriaId();

    void setCategoriaId(Long categoriaId);

    String getDescripcion();

    void setDescripcion(String descripcion);

    Double getLatitud();

    void setLatitud(Double latitud);

    Double getLongitud();

    void setLongitud(Double longitud);
}
