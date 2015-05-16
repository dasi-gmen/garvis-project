package icaro.aplicaciones.agentes.AgenteAplicacionDialogoGarvisCognitivo.tareas;


import icaro.aplicaciones.agentes.AgenteAplicacionDialogoGarvisCognitivo.objetivos.ObtenerInfoInterlocutor;
import icaro.aplicaciones.informacion.gestionGarvis.VocabularioGeneralGarvis;
import icaro.aplicaciones.recursos.comuGarvisChat.ItfUsoComuGarvisChat;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Focus;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;

public class ObtenerLibros extends TareaSincrona{

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
                    List<String> supplierNames = new ArrayList<String>();
                    supplierNames.add("sup1");
                    supplierNames.add("sup2");
                    supplierNames.add("sup3");
                    String space = " " ;
                    String mensajeprev = VocabularioGeneralGarvis.HasDichoBiblioteca2;
                    Iterator<String> iterator = supplierNames.iterator();
                    while (iterator.hasNext()) {
                          mensajeprev +=iterator.next()+ space;
                        } 
                    recComunicacionChat.enviarMensagePrivado(mensajeprev);
                }
                else {
                    identAgenteOrdenante = this.getAgente().getIdentAgente();
                     this.generarInformeConCausaTerminacion(identDeEstaTarea, contextoEjecucionTarea, identAgenteOrdenante, "Error-AlObtener:Interfaz:"+
                             VocabularioGeneralGarvis.IdentRecursoComunicacionChat, CausaTerminacionTarea.ERROR);
                        }
                    } catch(Exception e) {
                        this.generarInformeConCausaTerminacion(identDeEstaTarea, contextoEjecucionTarea, identAgenteOrdenante, "Error-Acceso:Interfaz:"+
                                VocabularioGeneralGarvis.IdentRecursoComunicacionChat, CausaTerminacionTarea.ERROR);
			e.printStackTrace();
		}
	}
  

}
