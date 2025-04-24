package classes;

import enums.tipoSexo;
import enums.tipoTalla;

public interface Stock {
	
	tipoTalla getTipoTalla();
	
	void setTipoTalla(tipoTalla talla);
	
	Integer getNumUnidades();
	
	void setNumUnidades(Integer numUnidades);
	
	tipoSexo getTipoSexo();
	
	void setTipoSexo(tipoSexo sexo);
	
	Integer getIdStock();

	 void setIdStock(Integer idStock);

}
