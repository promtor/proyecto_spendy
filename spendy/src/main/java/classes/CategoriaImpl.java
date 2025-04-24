package classes;

public class CategoriaImpl implements Categoria {
    private Long id;
    private Long usuarioId;
    private String nombre;

    public CategoriaImpl() {
    }

    public CategoriaImpl(Long id, Long usuarioId, String nombre) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nombre = nombre;
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
}
