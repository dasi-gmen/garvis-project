package icaro.aplicaciones.agentes.AgenteAplicacionDialogoGarvisCognitivo.tareas;
import icaro.aplicaciones.recursos.controlGarvisPane.ItfUsoControlGarvisPane;


import icaro.aplicaciones.agentes.AgenteAplicacionDialogoGarvisCognitivo.objetivos.ObtenerInfoInterlocutor;
import icaro.aplicaciones.informacion.gestionGarvis.VocabularioGeneralGarvis;
import icaro.aplicaciones.recursos.comuGarvisChat.ItfUsoComuGarvisChat;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Focus;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;
import icaro.aplicaciones.agentes.AgenteAplicacionDialogoGarvisCognitivo.objetivos.*;

import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;

import icaro.aplicaciones.recursos.comuGarvisChat.*;

public class ObtenerLibros extends TareaSincrona{

  /**
   *  Constructor
   *
   *@param           Description of the Parameter
   *@param    Description of the Parameter
   */
    private Objetivo contextoEjecucionTarea = null;
    public AddLibro op1 = new AddLibro();
    public List<String>suppliesNames;
    public List<String>suppliesNames2;
  @Override
	public void ejecutar(Object... params) {
  /**
   * Produce un saludo inicial y una presentacion de funcionalidad inicial al entrar en el sistema
   */
   String identDeEstaTarea=this.getIdentTarea();
            String identAgenteOrdenante = this.getIdentAgente();
          String identInterlocutor = (String)params[0];
          String nombrelibro = (String)params[1];
          String param = (String)params[2];
                    try {
//         // Se busca la interfaz del recurso en el repositorio de interfaces 
		ItfUsoComuGarvisChat recComunicacionChat = (ItfUsoComuGarvisChat) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(
						VocabularioGeneralGarvis.IdentRecursoComunicacionChat);          
                if (recComunicacionChat!=null){
                	//if(param == "1"){
                    recComunicacionChat.comenzar(identAgenteOrdenante);
                    if(param == "1"){
                    op1.SumarLibro(nombrelibro);
                   suppliesNames = op1.ListaLibros();
                    String space = " , " ;
                    String mensajeprev = VocabularioGeneralGarvis.HasDichoBiblioteca2;
                    String mensaje2 = VocabularioGeneralGarvis.PedirNuevoLibro;
                    Iterator<String> iterator = suppliesNames.iterator();
                   while (iterator.hasNext()) {
                          mensajeprev +=iterator.next()+ space;
                   }
                   mensajeprev += mensaje2;
                    recComunicacionChat.enviarMensagePrivado(mensajeprev);
                   }
                    else{
                    	String mensajeprev = "Libro Encontrado . Buen Provecho"; //VocabularioGeneralGarvis.HasDichoBiblioteca2;
	                    String mensaje2 = VocabularioGeneralGarvis.PedirNuevoLibro;
	                    suppliesNames2=op1.ListaLibros();
	                    Iterator<String> iterator = suppliesNames2.iterator();
	                   while (iterator.hasNext()) {
	                	   if(nombrelibro.equals(iterator.next()) ){
	                		   String mensaje = "Encontrado";
	                		   mensajeprev = mensaje ;
	                		    
	                	   }
	                	   else{
	                		   String mensaje = "Libro No encontrado";
	                		   mensajeprev = mensaje ;
	                	   }
	                   }
	                   if (suppliesNames2.size()== 0){
	                	   mensajeprev = "No has metido nada";
	                   }
	                   //mensajeprev += mensaje2;
	                   recComunicacionChat.enviarMensagePrivado(mensajeprev); 
                    }
                    
                }
                else {
                    identAgenteOrdenante = this.getAgente().getIdentAgente();
                     this.generarInformeConCausaTerminacion(identDeEstaTarea, contextoEjecucionTarea, identAgenteOrdenante, "Error-AlObtener:Interfaz:"+
                             VocabularioGeneralGarvis.IdentRecursoComunicacionChat, CausaTerminacionTarea.ERROR);
                        }


          ItfUsoControlGarvisPane recControlPane = (ItfUsoControlGarvisPane) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(
          VocabularioGeneralGarvis.IdentRecursoControlGarvisPane);  

          if (recControlPane!=null ){
              recControlPane.comenzar(identAgenteOrdenante);
              //TODO
          }else {
            identAgenteOrdenante = this.getAgente().getIdentAgente();
            this.generarInformeConCausaTerminacion(identDeEstaTarea, contextoEjecucionTarea, identAgenteOrdenante, "Error-AlObtener:Interfaz:"+
                   VocabularioGeneralGarvis.IdentRecursoControlGarvisPane, CausaTerminacionTarea.ERROR);
          }


                        
                    } catch(Exception e) {
                        this.generarInformeConCausaTerminacion(identDeEstaTarea, contextoEjecucionTarea, identAgenteOrdenante, "Error-Acceso:Interfaz:"+
                                VocabularioGeneralGarvis.IdentRecursoComunicacionChat, CausaTerminacionTarea.ERROR);
			e.printStackTrace();
		}
	}
  

}
