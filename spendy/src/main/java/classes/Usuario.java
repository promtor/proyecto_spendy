package classes;

import java.math.BigDecimal;

public interface Usuario {
    Long getId();

    void setId(Long id);

    String getNombre();

    void setNombre(String nombre);

    String getCorreo();

    void setCorreo(String correo);

    String getPasswordHash();

    void setPasswordHash(String passwordHash);

    String getTema();

    void setTema(String tema);

    BigDecimal getLimiteMensual();

    void setLimiteMensual(BigDecimal limiteMensual);
}
