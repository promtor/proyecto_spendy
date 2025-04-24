package classes;

public interface Ticket {
    Long getId();

    void setId(Long id);

    Long getGastoId();

    void setGastoId(Long gastoId);

    String getImagenPath();

    void setImagenPath(String imagenPath);

    String getTextoOCR();

    void setTextoOCR(String textoOCR);
}
