package classes;

public class UsuarioImpl implements Usuario {
	
	private String nombre, apellidos, correoElectronico, contrasenya;

	public UsuarioImpl(String nombre, String apellidos, String correoElectronico, String contrasenya) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correoElectronico = correoElectronico;
		this.contrasenya = contrasenya;
	}
	

	// ----------------------------- Metodos Get y Set -----------------------------------------//
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
		
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
		
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	// ----------------------------- Metodos Auxiliares -----------------------------------------//
	/*
	@Override
	public String toString() {
		
	}

	@Override
	public int hashCode() {
		
	}

	@Override
	public boolean equals(Object obj) {

	}*/
}
