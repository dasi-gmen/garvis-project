/*
 * SolicitarDatos.java
 *
 * Creado 23 de abril de 2007, 12:52
 *
 * Telefonica I+D Copyright 2006-2007
 */
package icaro.aplicaciones.agentes.AgenteAplicacionDialogoGarvisCognitivo.tareas;
import icaro.aplicaciones.recursos.controlGarvisPane.ItfUsoControlGarvisPane;

import icaro.aplicaciones.informacion.gestionGarvis.VocabularioGeneralGarvis;
import icaro.aplicaciones.recursos.comuGarvisChat.ItfUsoComuGarvisChat;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Tarea;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;
/**
 * 
 * @author F Garijo
 */
public class SolicitarInfoInicial extends TareaSincrona {
//    private String identAgenteOrdenante ;
    private Objetivo contextoEjecucionTarea = null;
	@Override
	public void ejecutar(Object... params) {		
            String identDeEstaTarea=this.getIdentTarea();
            String identAgenteOrdenante = this.getIdentAgente();
          String identRecursoComunicacionChat = (String)params[0];
                    try {
//         // Se busca la interfaz del recurso en el repositorio de interfaces 
		ItfUsoComuGarvisChat recComunicacionChat = (ItfUsoComuGarvisChat) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfaz(
						NombresPredefinidos.ITF_USO + identRecursoComunicacionChat);          
                if (recComunicacionChat!=null){
                    recComunicacionChat.comenzar(identAgenteOrdenante);
                    recComunicacionChat.enviarMensagePrivado(VocabularioGeneralGarvis.SaludoInicial1);
                }
                else {
                    identAgenteOrdenante = this.getAgente().getIdentAgente();
                     this.generarInformeConCausaTerminacion(identDeEstaTarea, contextoEjecucionTarea, identAgenteOrdenante, "Error-AlObtener:Interfaz:"+identRecursoComunicacionChat, CausaTerminacionTarea.ERROR);
                        }
                
                ItfUsoControlGarvisPane recControlPane = (ItfUsoControlGarvisPane) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(
                        VocabularioGeneralGarvis.IdentRecursoControlGarvisPane);  
                
                if (recControlPane!=null ){
                    recControlPane.comenzar(identAgenteOrdenante);
                    //TODO �Algo especial?
                }else {
                  identAgenteOrdenante = this.getAgente().getIdentAgente();
                  this.generarInformeConCausaTerminacion(identDeEstaTarea, contextoEjecucionTarea, identAgenteOrdenante, "Error-AlObtener:Interfaz:"+
                         VocabularioGeneralGarvis.IdentRecursoControlGarvisPane, CausaTerminacionTarea.ERROR);
                }
                
                
                
                    } catch(Exception e) {
                        this.generarInformeConCausaTerminacion(identDeEstaTarea, contextoEjecucionTarea, identAgenteOrdenante, "Error-Acceso:Interfaz:"+identRecursoComunicacionChat, CausaTerminacionTarea.ERROR);
			e.printStackTrace();
		}
	}
}
