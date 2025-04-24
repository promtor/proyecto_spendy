package classes;

import java.math.BigDecimal;

public class UsuarioImpl implements Usuario {
    private Long id;
    private String nombre;
    private String correo;
    private String passwordHash;
    private String tema;
    private BigDecimal limiteMensual;

    public UsuarioImpl() {
    }

    public UsuarioImpl(Long id, String nombre, String correo, String passwordHash,
            String tema, BigDecimal limiteMensual) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.passwordHash = passwordHash;
        this.tema = tema;
        this.limiteMensual = limiteMensual;
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
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getCorreo() {
        return correo;
    }

    @Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String getPasswordHash() {
        return passwordHash;
    }

    @Override
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public String getTema() {
        return tema;
    }

    @Override
    public void setTema(String tema) {
        this.tema = tema;
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
