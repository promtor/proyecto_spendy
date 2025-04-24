package classes;


import enums.tipoSexo;
import enums.tipoTalla;

public class StockImpl implements Stock {

	private Integer numUnidades;
	private Integer idStock;
	private tipoTalla talla;
	private tipoSexo sexo;
	
	
		
	public StockImpl(Integer numUnidades, tipoTalla talla, tipoSexo sexo) {
		this.numUnidades = numUnidades;
		this.talla = talla;
		this.sexo = sexo;
	}
	
	

	// ----------------------------- Metodos Get y Set-----------------------------------------//
	public tipoTalla getTipoTalla() {
		return talla;
	}

	public void setTipoTalla(tipoTalla talla) {
		this.talla = talla;
		
	}

	public Integer getNumUnidades() {
		return numUnidades;
	}

	public void setNumUnidades(Integer numUnidades) {
		this.numUnidades = numUnidades;
	}

	public tipoSexo getTipoSexo() {
		return sexo;
	}

	public void setTipoSexo(tipoSexo sexo) {
		this.sexo = sexo;
	}
	
	public Integer getIdStock() {
		return idStock;
	}

	public void setIdStock(Integer idStock) {
		this.idStock = idStock;
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
