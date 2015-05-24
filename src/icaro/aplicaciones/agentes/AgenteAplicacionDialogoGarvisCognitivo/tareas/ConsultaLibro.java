package icaro.aplicaciones.agentes.AgenteAplicacionDialogoGarvisCognitivo.tareas;

import icaro.aplicaciones.informacion.gestionGarvis.VocabularioGeneralGarvis;
import icaro.aplicaciones.recursos.comuGarvisChat.ItfUsoComuGarvisChat;
import icaro.aplicaciones.recursos.controlGarvisPane.ItfUsoControlGarvisPane;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

public class ConsultaLibro extends TareaSincrona {
	/**
	   *  Constructor
	   *
	   *@param           Description of the Parameter
	   *@param    Description of the Parameter
	   */
	    private Objetivo contextoEjecucionTarea = null;
	  @Override
		public void ejecutar(Object... params) {
	  /**
	   * Produce un saludo inicial y una presentacion de funcionalidad inicial al entrar en el sistema
	   */
	   String identDeEstaTarea=this.getIdentTarea();
	   String identAgenteOrdenante = this.getIdentAgente();
	   String identInterlocutor = (String)params[0];
	         
	   try {
//	         // Se busca la interfaz del recurso en el repositorio de interfaces 
					ItfUsoComuGarvisChat recComunicacionChat = (ItfUsoComuGarvisChat) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(
					VocabularioGeneralGarvis.IdentRecursoComunicacionChat);          
				  if (recComunicacionChat!=null ){
				      recComunicacionChat.comenzar(identAgenteOrdenante);
				      String mensajeAenviar ="Que libro deseas consultar ?" ;//VocabularioGeneralGarvis.HasDichoBiblioteca3;
				      recComunicacionChat.enviarMensagePrivado(mensajeAenviar);
				  }else {
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
