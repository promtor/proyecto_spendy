package classes;

import java.math.BigDecimal;

public interface Limite {
    Long getUsuarioId();
    void setUsuarioId(Long usuarioId);
    BigDecimal getLimiteMensual();
    void setLimiteMensual(BigDecimal limiteMensual);
}
