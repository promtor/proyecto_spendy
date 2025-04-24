package dao;

import classes.Ticket;
import classes.TicketImpl;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ManagerTickets {
    private static final List<Ticket> tickets = new ArrayList<>();
    private static final AtomicLong seqId = new AtomicLong(1);

    public static Ticket crearTicket(JSONObject body) {
        Long id = seqId.getAndIncrement();
        TicketImpl t = new TicketImpl(
            id,
            body.getLong("gastoId"),
            body.getString("imagenPath"),
            body.getString("textoOCR")
        );
        tickets.add(t);
        return t;
    }

    public static List<Ticket> obtenerTickets() {
        return new ArrayList<>(tickets);
    }

    public static Ticket actualizarTicket(Long id, String ocr) {
        for (Ticket t : tickets) {
            if (t.getId().equals(id)) {
                t.setTextoOCR(ocr);
                return t;
            }
        }
        return null;
    }

    public static boolean borrarTicket(Long id) {
        return tickets.removeIf(t -> t.getId().equals(id));
    }
}