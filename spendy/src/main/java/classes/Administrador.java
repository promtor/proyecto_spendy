package classes;

public interface Administrador extends Usuario {
	
	String getNombre();

	void setNombre(String nombre);

	String getApellidos();

	void setApellidos(String apellidos);

	String getCorreoElectronico();

	void setCorreoElectronico(String correoElectronico);

	String getContrasenya();

	void setContrasenya(String contrasenya);
	
}
