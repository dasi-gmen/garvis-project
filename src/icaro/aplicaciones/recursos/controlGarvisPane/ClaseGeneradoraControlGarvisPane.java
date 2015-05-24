package icaro.aplicaciones.recursos.comuGarvisPane;

import icaro.aplicaciones.informacion.gestionGarvis.VocabularioGeneralGarvis;
import icaro.aplicaciones.recursos.comuGarvisPane.*;
import icaro.aplicaciones.recursos.comuGarvisPane.imp.util.ConexionCONTROL;
import icaro.infraestructura.entidadesBasicas.interfaces.InterfazUsoAgente;
import icaro.infraestructura.patronRecursoSimple.imp.ImplRecursoSimple;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ClaseGeneradoraComuGarvisChat extends ImplRecursoSimple implements
		ItfUsoComuGarvisChat {

	private static final long serialVersionUID = 1L;
	private ConexionCONTROL conexControl ;

	public ClaseGeneradoraComuGarvisChat(String idInstanciaRecurso) throws Exception {
		
		super(idInstanciaRecurso);
// obtenemos las propiedades del recurso que deben estar definidas en las propiedades del recurso
        identExtractorSem = VocabularioGeneralGarvis.IdentRecursoExtractorSemantico;
		try {
		    conexControl = new ConexionCONTROL();
		    interpreteMsgGarvis = new InterpreteMsgsGARVIS(conexControl);
		    conexControl.setInterpreteMsgs(interpreteMsgGarvis);
		    trazas.aceptaNuevaTraza(new InfoTraza(this.getId(),
		      "Creando el recurso "+idInstanciaRecurso,
		        InfoTraza.NivelTraza.debug));
        } catch (Exception e) {
                        e.printStackTrace();
                        this.trazas.aceptaNuevaTraza(new InfoTraza(id,
  				"Se ha producido un error al crear el extractor semantico  "+e.getMessage()+
                                ": Verificar los parametros de creacion "
                                + "rutas y otros",
  				InfoTraza.NivelTraza.error));
			this.itfAutomata.transita("error");
			throw e;
		}
        }
private void generarErrorCreacionComponente(String textoMensaje){
    this.trazas.aceptaNuevaTraza(new InfoTraza(id,
  				"Se ha producido un error al crear el extractor semantico  "+textoMensaje+
                                ": Verificar los parametros de creacion ",
  				InfoTraza.NivelTraza.error));
			this.itfAutomata.transita("error");
                        
}


  //@Override
  public void setIdentAgenteAReportar(String identAgte ){
      identAgenteAReportar = identAgte;
      InterfazUsoAgente itfAgteControlador = null;
      try {
          itfAgteControlador = (InterfazUsoAgente) this.repoIntfaces.obtenerInterfazUso(identAgenteAReportar);
      } catch (Exception ex) {
          Logger.getLogger(ClaseGeneradoraComuGarvisChat.class.getName()).log(Level.SEVERE, null, ex);
      }
     if (itfAgteControlador == null) this.generarErrorCreacionComponente("itfAgteAreportar es null");
     else interpreteMsgGarvis.setItfusoAgenteGestorDialogo(itfAgteControlador);
  }
  //@Override
  public void termina() {  
    try {
      super.termina();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //@Override
  public void enviarMensagePrivado( String mensaje)throws Exception{
      conexControl.sendMessage(mensaje);
  }
  //@Override
  public void desconectar( )throws Exception{
      conexControl.disconnect();
  }

      //@Override
  public void comenzar ( String identAgteControlador)throws Exception{
    if (!conectado){
      InterfazUsoAgente itfAgteControlador;
          try {
              itfAgteControlador = (InterfazUsoAgente) this.repoIntfaces.obtenerInterfazUso(identAgteControlador);
         if (itfAgteControlador == null){
             this.generarErrorCreacionComponente("itfAgteControlador es null");
         }else interpreteMsgGarvis.setItfusoAgenteGestorDialogo(itfAgteControlador);
         ItfUsoExtractorSemantico itfExtractorSem=(ItfUsoExtractorSemantico) this.repoIntfaces.obtenerInterfazUso(identExtractorSem);
         if (itfExtractorSem == null){
             this.generarErrorCreacionComponente("itfExtractorSemantico es null");
         }else interpreteMsgGarvis.setItfusoRecExtractorSemantico(itfExtractorSem);
         if (itfExtractorSem == null ||itfAgteControlador == null )throw new Exception();
         else{
             interpreteMsgGarvis.setIdentAgenteGestorDialogo(VocabularioGeneralGarvis.IdentAgenteAplicacionDialogoGarvis);
             interpreteMsgGarvis.setIdentConexion(VocabularioGeneralGarvis.IdentConexionAgte);
             //conexControl.setVerbose(true);
             //conectar( url, chanel, nickname);
         }
         } catch (Exception ex) {
              Logger.getLogger(ClaseGeneradoraComuGarvisChat.class.getName()).log(Level.SEVERE, null, ex);
          }
         
         
            conexControl.connect();
            conectado=true;//conexControl.isConnected();

    }
  } 
}