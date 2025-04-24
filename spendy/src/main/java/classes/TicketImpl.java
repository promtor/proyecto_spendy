package classes;

public class TicketImpl implements Ticket {
    private Long id;
    private Long gastoId;
    private String imagenPath;
    private String textoOCR;

    public TicketImpl() {
    }

    public TicketImpl(Long id, Long gastoId, String imagenPath, String textoOCR) {
        this.id = id;
        this.gastoId = gastoId;
        this.imagenPath = imagenPath;
        this.textoOCR = textoOCR;
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
    public Long getGastoId() {
        return gastoId;
    }

    @Override
    public void setGastoId(Long gastoId) {
        this.gastoId = gastoId;
    }

    @Override
    public String getImagenPath() {
        return imagenPath;
    }

    @Override
    public void setImagenPath(String imagenPath) {
        this.imagenPath = imagenPath;
    }

    @Override
    public String getTextoOCR() {
        return textoOCR;
    }

    @Override
    public void setTextoOCR(String textoOCR) {
        this.textoOCR = textoOCR;
    }
}
