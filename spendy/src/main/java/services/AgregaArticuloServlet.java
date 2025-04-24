package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Articulo;
import classes.ArticuloImpl;
import dao.ManagerArticulos;
import enums.tipoPrenda;

@WebServlet("/addArticulo")
public class AgregaArticuloServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Lista temporal para almacenar artículos añadidos dinámicamente
    private static List<Articulo> listaDinamica = ManagerArticulos.getArticulos();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // Configurar codificación para evitar problemas con acentos
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // Obtener parámetros del formulario
        Integer id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        Float precio = Float.parseFloat(request.getParameter("precio"));
        Float descuento = Float.parseFloat(request.getParameter("descuento"));
        String tipoStr = request.getParameter("tipo");
        tipoPrenda tipo = tipoPrenda.valueOf(tipoStr);

        // Crear nuevo artículo
        Articulo nuevo = new ArticuloImpl(id, nombre, descripcion, precio, descuento, tipo);


        // Usar directamente el método del DAO como repositorio
        ManagerArticulos.addArticulo(nuevo);

        // Confirmación
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Artículo añadido correctamente</h3>");
        out.println("<p><strong>ID:</strong> " + id + "</p>");
        out.println("<p><strong>Nombre:</strong> " + nombre + "</p>");
        out.println("<a href=\"index.jsp\">Volver al inicio</a>");
        out.println("</body></html>");
    }
}

