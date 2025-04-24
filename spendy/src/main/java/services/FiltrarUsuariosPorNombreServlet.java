package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import classes.Usuario;
import dao.ManagerUsuarios;

@WebServlet(urlPatterns = "/filtrarUsuariosPorNombre")
public class FiltrarUsuariosPorNombreServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Cache-Control", "no-store");
		PrintWriter writer;
		
		JSONArray arrayUsuarios = new JSONArray();
		String nombre = req.getParameter("nombre");
		
		try {
			writer = resp.getWriter();
			
			for (Usuario usuario : ManagerUsuarios.getUsuarios()){
				
				String nombreUsuario = usuario.getNombre();
				if(nombreUsuario.contains(nombre)) {
					JSONObject objetoJSON = new JSONObject();
					
					objetoJSON.put("nombre",usuario.getNombre());
					objetoJSON.put("apellidos",usuario.getApellidos());
					objetoJSON.put("correoElectronico",usuario.getCorreoElectronico());
					objetoJSON.put("contrasenya",usuario.getContrasenya());
					
					arrayUsuarios.put(objetoJSON);
				}
			}
			
			JSONObject 	respuesta = new JSONObject();
			
			if (!arrayUsuarios.isEmpty()) {
				respuesta.put("cod", "ok");
				respuesta.put("msg", "ok");	
			} 
			else 
			{
				respuesta.put("cod", "ERROR");
				respuesta.put("msg", "Listado vacio");
			}
			
			respuesta.put("res", arrayUsuarios);

			writer.write(respuesta.toString());
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	

}