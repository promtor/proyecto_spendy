package classes;

import java.math.BigDecimal;

public class LimiteImpl implements Limite {
    private Long usuarioId;
    private BigDecimal limiteMensual;

    public LimiteImpl() {}

    public LimiteImpl(Long usuarioId, BigDecimal limiteMensual) {
        this.usuarioId = usuarioId;
        this.limiteMensual = limiteMensual;
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
    public BigDecimal getLimiteMensual() {
        return limiteMensual;
    }

    @Override
    public void setLimiteMensual(BigDecimal limiteMensual) {
        this.limiteMensual = limiteMensual;
    }
}
