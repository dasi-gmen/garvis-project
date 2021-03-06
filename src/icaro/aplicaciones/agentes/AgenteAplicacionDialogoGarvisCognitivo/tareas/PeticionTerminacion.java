package icaro.aplicaciones.agentes.AgenteAplicacionDialogoGarvisCognitivo.tareas;
import icaro.aplicaciones.recursos.controlGarvisPane.ItfUsoControlGarvisPane;

import icaro.aplicaciones.informacion.gestionGarvis.VocabularioGeneralGarvis;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Tarea;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.comunicacion.AdaptadorRegRMI;
import icaro.infraestructura.entidadesBasicas.comunicacion.EventoRecAgte;
import icaro.infraestructura.entidadesBasicas.comunicacion.MensajeSimple;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.patronAgenteReactivo.factoriaEInterfaces.ItfUsoAgenteReactivo;




public class PeticionTerminacion extends Tarea {
//        private String identDeEstaTarea= "PermitirAcceso";
        private String identAgenteOrdenante;
        private Objetivo contextoEjecucionTarea = null;
//        private String identRecursoVisualizacionAcceso = "VisualizacionAcceso1";
	@Override
	public void ejecutar(Object... params) {
	
	// Cerramos el visualizador y pedimos al gestor de agentes que termine
             String identDeEstaTarea=getClass().getSimpleName();
             String identRecursoVisualizacionAcceso = (String)params[0];
               try {
                  
                     identAgenteOrdenante = this.getAgente().getIdentAgente();
			
                  
                    ItfUsoAgenteReactivo gestorAgentes = (ItfUsoAgenteReactivo) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfaz(NombresPredefinidos.ITF_USO+NombresPredefinidos.NOMBRE_GESTOR_AGENTES);
			 if (gestorAgentes==null)
                            gestorAgentes = (ItfUsoAgenteReactivo)AdaptadorRegRMI.getItfAgenteRemoto(NombresPredefinidos.NOMBRE_GESTOR_AGENTES, NombresPredefinidos.ITF_USO);
                            if (gestorAgentes==null)
                            this.generarInformeConCausaTerminacion(identDeEstaTarea, contextoEjecucionTarea, identAgenteOrdenante, "Error-AlObtener:Interfaz_Agente:"+NombresPredefinidos.NOMBRE_GESTOR_AGENTES, CausaTerminacionTarea.ERROR);
                        else {
                            gestorAgentes.aceptaEvento(new EventoRecAgte("peticion_terminar_todo", this.getAgente().getIdentAgente(), null));
			
                            MensajeSimple mensaje = new MensajeSimple();
                            mensaje.setEmisor("Task:PedirTerminacionAGestor");
                            mensaje.setReceptor("AgenteAplicacionAcceso1");
                            mensaje.setContenido("peticionTerminacion");
                            this.getAgente().aceptaMensaje(mensaje);
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

                        
		} catch (Exception e) {
			// TODO Auto-generated catch block
                      this.generarInformeConCausaTerminacion(identDeEstaTarea, contextoEjecucionTarea, identAgenteOrdenante, "Error-AlUtilizar:Interfaces_Recurso:"+identRecursoVisualizacionAcceso, CausaTerminacionTarea.ERROR);
			e.printStackTrace();
		}
		
	}



}
