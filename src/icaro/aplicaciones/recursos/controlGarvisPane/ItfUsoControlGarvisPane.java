package icaro.aplicaciones.recursos.controlGarvisPane;

import icaro.aplicaciones.recursos.extractorSemantico.*;
import icaro.infraestructura.patronRecursoSimple.ItfUsoRecursoSimple;


public interface ItfUsoControlGarvisPane extends ItfUsoRecursoSimple {
    public void comenzar ( String identAgteControlador)throws Exception;;
    
    public String obtenerLibros(String param, String nombreLibro)throws Exception;
    
    //public void recibirMensajePrivado(String mensaje) throws Exception;
    public void desconectar( )throws Exception;

	public void meterComidaMicro(String string)throws Exception;

	public void sacarComidaMicro()throws Exception;
	
	public void meterComidaNevera(String string)throws Exception;

	public boolean sacarComidaNevera(String string)throws Exception;
        
}