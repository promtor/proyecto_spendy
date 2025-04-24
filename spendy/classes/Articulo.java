package classes;


import enums.tipoPrenda;

public interface Articulo {
	
	void setIdArticulo(Integer articulo);
	
	Integer getIdArticulo();
	
	void setNombre(String nombre);
	
	String getNombre();
	
	void setDescripcion(String descripcion);
	
	String getDescripcion();
	
	void setPrecio(Float precio);
	
	Float getPrecio();
	
	void setDescuento(Float descuento);
	
	Float getDescuento();
	
	tipoPrenda getTipo();
	
	void setTipo(tipoPrenda prenda);
	
	
}
