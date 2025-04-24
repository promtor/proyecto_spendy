package classes;


import enums.tipoPrenda;

public class ArticuloImpl implements Articulo {

	private Integer idArticulo;
	private String nombre, descripcion;
	private Float precio, descuento;
	private tipoPrenda prenda;

			
	public ArticuloImpl(Integer idArticulo, String nombre, String descripcion, Float precio, Float descuento, tipoPrenda prenda) {
		super();
		this.idArticulo = idArticulo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.descuento = descuento;
		this.prenda = prenda;
	}
	


	
	// ----------------------------- Metodos Get y Set -----------------------------------------//
	public void setIdArticulo(Integer articulo) {
		this.idArticulo = articulo;
	}

	public Integer getIdArticulo() {
		return idArticulo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}

	public Float getDescuento() {
		return descuento;
	}

	public tipoPrenda getTipo() {
		return prenda;
	}

	public void setTipo(tipoPrenda prenda) {
		this.prenda = prenda;
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
