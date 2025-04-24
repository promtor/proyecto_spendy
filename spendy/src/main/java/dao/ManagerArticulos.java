package dao;

import java.util.LinkedList;
import java.util.List;

import classes.Articulo;
import classes.ArticuloImpl;
import enums.tipoPrenda;

public class ManagerArticulos {

    // Lista estática que actúa como repositorio en memoria
    private static List<Articulo> listaArticulos = new LinkedList<>();

    // Bloque estático para inicializar solo una vez los artículos por defecto
    static {
        // Articulo 1
        listaArticulos.add(new ArticuloImpl(35627, "Chandal Nike", "Prenda deportiva completa", 35.65f, 0.25f, tipoPrenda.Chandal));
        // Articulo 2
        listaArticulos.add(new ArticuloImpl(35322, "Camiseta Betis", "Camiseta cadete oficial del Betis", 45.65f, 0.35f, tipoPrenda.Camiseta));
        // Articulo 3
        listaArticulos.add(new ArticuloImpl(75421, "Camiseta Sevilla", "Camiseta adulto oficial del Sevilla", 50.65f, 0.35f, tipoPrenda.Camiseta));
        // Articulo 4
        listaArticulos.add(new ArticuloImpl(75471, "Camiseta Madrid", "Camiseta adulto oficial del Madrid", 90.65f, 0.35f, tipoPrenda.Camiseta));
        // Articulo 5
        listaArticulos.add(new ArticuloImpl(15471, "Camiseta Universidad", "Camiseta oficial de la Universidad Loyola Andalucía", 20.85f, 0.35f, tipoPrenda.Sudadera));
    }

    // Devuelve la lista de artículos completa
    public static List<Articulo> getArticulos() {
        return listaArticulos;
    }

    // Añade un artículo a la lista
    public static void addArticulo(Articulo a) {
        listaArticulos.add(a);
    }
}
