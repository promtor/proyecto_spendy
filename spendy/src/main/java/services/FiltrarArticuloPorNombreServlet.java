package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import classes.Articulo;
import dao.ManagerArticulos;


@WebServlet(urlPatterns = {"/filtrarArticuloNombre"})
public class FiltrarArticuloPorNombreServlet extends HttpServlet{


	private static final long serialVersionUID = 7961855498254817655L;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Cache-Control", "no-store");
		PrintWriter writer;
		
	
		JSONArray arrayArticulos = new JSONArray();
		String name = req.getParameter("nombre");

		try {
			writer= resp.getWriter();
			
			for (Articulo articulo : ManagerArticulos.getArticulos()) {
				
				String nombreArticulo = articulo.getNombre();
				
				if (nombreArticulo.contains(name)) {
					
					JSONObject objetoJSON = new JSONObject(); 
					
					objetoJSON.put("idArticulo", articulo.getIdArticulo());
					objetoJSON.put("nombre", articulo.getNombre());
					objetoJSON.put("descripcion", articulo.getDescripcion());
					objetoJSON.put("precio", articulo.getPrecio());
					objetoJSON.put("descuento", articulo.getDescuento());
					objetoJSON.put("prenda", articulo.getTipo());
											
					arrayArticulos.put(objetoJSON);
					
				}
			}
				
				JSONObject respuesta = new JSONObject();
				
				if (!arrayArticulos.isEmpty()) {
					respuesta.put("cod", "ok");
					respuesta.put("msg", "ok");	
				} else {
					respuesta.put("cod", "ERROR");
					respuesta.put("msg", "Listado vacio");
				}
				
				respuesta.put("res", arrayArticulos);
				
				writer.write(respuesta.toString());
			
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

