package icaro.aplicaciones.recursos.controlGarvisPane;

import icaro.aplicaciones.recursos.extractorSemantico.*;
import icaro.infraestructura.patronRecursoSimple.ItfUsoRecursoSimple;


public interface ItfUsoControlGarvisPane extends ItfUsoRecursoSimple {
    public void comenzar ( String identAgteControlador)throws Exception;;

    public void neveraAddProduct(String producto)throws Exception;
    public void neveraRemoveProduct(String producto)throws Exception;
    public boolean neveraHasProduct(String producto)throws Exception;
    
    public void bibliotecaAddBook(String book)throws Exception;
    public void bibliotecaReadBook(String book)throws Exception;
    public boolean bibliotecaHasBook(String book)throws Exception;
    
    //public void recibirMensajePrivado(String mensaje) throws Exception;
    public void desconectar( )throws Exception;
        
}