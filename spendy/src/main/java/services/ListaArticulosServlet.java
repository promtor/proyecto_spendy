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


@WebServlet(urlPatterns = "/getListaArticulos")
public class ListaArticulosServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Cache-Control", "no-store");
		PrintWriter writer;
		
		JSONArray arrayArticulos = new JSONArray();
		
		try {
			writer = resp.getWriter();
			
			for (Articulo art : ManagerArticulos.getArticulos()){
				
				JSONObject objetoJSON = new JSONObject();
				
				objetoJSON.put("idArticulo", art.getIdArticulo());
				objetoJSON.put("nombre", art.getNombre());
				objetoJSON.put("descripcion", art.getDescripcion());
				objetoJSON.put("precio", art.getPrecio());
				objetoJSON.put("descuento", art.getDescuento());
				objetoJSON.put("prenda", art.getTipo());

				
				arrayArticulos.put(objetoJSON);
			}
			

			JSONObject 	respuesta = new JSONObject();
			
			if (!arrayArticulos.isEmpty()) {
				respuesta.put("cod", "ok");
				respuesta.put("msg", "ok");	
			} 
			else{
				respuesta.put("cod", "ERROR");
				respuesta.put("msg", "Listado vacio");
			}
			
			respuesta.put("res", arrayArticulos);

			writer.write(respuesta.toString());
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
