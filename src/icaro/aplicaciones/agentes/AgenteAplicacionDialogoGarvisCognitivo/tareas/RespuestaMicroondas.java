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

public class RespuestaMicroondas extends TareaSincrona{

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
//         // Se busca la interfaz del recurso en el repositorio de interfaces 
		ItfUsoComuGarvisChat recComunicacionChat = (ItfUsoComuGarvisChat) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(
						VocabularioGeneralGarvis.IdentRecursoComunicacionChat);          
                if (recComunicacionChat!=null){
                    recComunicacionChat.comenzar(identAgenteOrdenante);
                    
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
          
          String mensajeAenviar = (String)params[1];//VocabularioGeneralGarvis.HasDichoMicroondas;
          //String[] saludos = VocabularioGeneralGarvis.SaludoInicial2.split(":");
          //Double i = (Math.random() * (saludos.length));
          recComunicacionChat.enviarMensagePrivado(mensajeAenviar);
          if(params.length==4){
        	  String accion = (String)params[2];
        	  if (((String)params[2]).equalsIgnoreCase("meter")){
      
        		  recControlPane.meterComidaMicro((String)params[3]);
        	  }
          }
          if(params.length==3){
        	  if (((String)params[2]).equalsIgnoreCase("sacar")){
        		  recControlPane.sacarComidaMicro();
        	  }
          }
          

                        
                    } catch(Exception e) {
                        this.generarInformeConCausaTerminacion(identDeEstaTarea, contextoEjecucionTarea, identAgenteOrdenante, "Error-Acceso:Interfaz:"+
                                VocabularioGeneralGarvis.IdentRecursoComunicacionChat, CausaTerminacionTarea.ERROR);
			e.printStackTrace();
		}
	}
  

}
