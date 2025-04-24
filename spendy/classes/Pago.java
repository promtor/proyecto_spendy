package classes;

import java.sql.Date;

import enums.tipoTarjeta;

public interface Pago {

	Float getNumeroTarjeta();
	
	void setNumeroTarjeta(Float numeroTarjeta);
	
	String getNombreTarjeta();
	
	void setNombreTarjeta(String nombreTarjeta);
	
	Integer getCCV();
	
	void setCCV(Integer ccv);
	
	Date getFechaCaducidad();
	
	void setFechaCaducidad(Date fechaCaducidad);
	
	tipoTarjeta getTipoTarjeta();
	
	void setTipoTarjeta(tipoTarjeta tipoTarjeta);

}
