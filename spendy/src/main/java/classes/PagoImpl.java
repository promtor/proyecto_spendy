package classes;

import java.sql.Date;

import enums.tipoTarjeta;

public class PagoImpl implements Pago {
	
	private Integer ccv;
	private Float numeroTarjeta;
	private tipoTarjeta tarjeta;
	private String nombreTarjeta;
	private Date fechaCaducidad;
	
	public PagoImpl (String nombreTarjeta, Float numeroTarjeta, Integer ccv, tipoTarjeta tipoTarjeta, Date fechaCaducidad) {
		super();
		this.nombreTarjeta = nombreTarjeta;
		this.numeroTarjeta = numeroTarjeta;
		this.fechaCaducidad = fechaCaducidad;
		this.ccv = ccv;
		this.tarjeta = tipoTarjeta;
	}

	// ----------------------------- Metodos Get y Set-----------------------------------------//
	public Float getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(Float numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getNombreTarjeta() {
		return nombreTarjeta;
	}


	public void setNombreTarjeta(String nombreTarjeta) {
		this.nombreTarjeta  = nombreTarjeta;
		
	}

	public void setCCV(Integer ccv) {
		this.ccv = ccv;
	}
	
	public Integer getCCV() {
		return ccv;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
		
	}

	public tipoTarjeta getTipoTarjeta() {
		return tarjeta;
	}

	public void setTipoTarjeta(tipoTarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	
	// ----------------------------- Metodos Auxiliares-----------------------------------------//
	/*
	@Override
	public String toString() {

	}

	@Override
	public int hashCode() {

	}

	@Override
	public boolean equals(Object obj) {

	}
    */
	
	
}
