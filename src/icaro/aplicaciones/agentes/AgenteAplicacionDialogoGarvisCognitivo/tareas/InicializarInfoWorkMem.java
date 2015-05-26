/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package icaro.aplicaciones.agentes.AgenteAplicacionDialogoGarvisCognitivo.tareas;
import icaro.aplicaciones.recursos.controlGarvisPane.ItfUsoControlGarvisPane;
import icaro.aplicaciones.agentes.AgenteAplicacionDialogoGarvisCognitivo.objetivos.*;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Focus;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;

/**
 *
 * @author Francisco J Garijo
 */
public class InicializarInfoWorkMem extends TareaSincrona{

   @Override
   public void ejecutar(Object... params) {
	   try {
			//     Objetivo objetivoEjecutantedeTarea = (Objetivo)params[0];
			String identTarea = this.getIdentTarea();
			String nombreAgenteEmisor = this.getIdentAgente();
			this.getItfConfigMotorDeReglas().setDepuracionActivationRulesDebugging(true);
			this.getItfConfigMotorDeReglas().setfactHandlesMonitoring_afterActivationFired_DEBUGGING(true);
			this.getEnvioHechos().insertarHechoWithoutFireRules(new Focus());
			this.getEnvioHechos().insertarHecho(new ObtenerInfoInterlocutor());
			this.getEnvioHechos().insertarHecho(new ApagarTele());
			this.getEnvioHechos().insertarHecho(new EncenderMicro());
			this.getEnvioHechos().insertarHecho(new ApagarMicro());
			this.getEnvioHechos().insertarHecho(new AbrirMicro());
			this.getEnvioHechos().insertarHecho(new CerrarMicro());
			this.getEnvioHechos().insertarHecho(new EncenderTele());
			this.getEnvioHechos().insertarHecho(new GrabarProgramaTV());
			this.getEnvioHechos().insertarHecho(new SintonizaTV());
			this.getEnvioHechos().insertarHecho(new AddLibro());
			this.getEnvioHechos().insertarHecho(new LeerLibro());
			this.getEnvioHechos().insertarHecho(new MeterComidaMicro());
             
       } catch (Exception e) {
			 e.printStackTrace();
                         trazas.aceptaNuevaTraza(new InfoTraza(this.getIdentAgente(), "Error al ejecutar la tarea : "+this.getIdentTarea() + e, InfoTraza.NivelTraza.error));
       }
   }

}
