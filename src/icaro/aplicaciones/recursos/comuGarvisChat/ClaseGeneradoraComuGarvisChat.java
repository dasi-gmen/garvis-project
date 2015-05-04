package icaro.aplicaciones.recursos.comuGarvisChat;

import icaro.aplicaciones.informacion.gestionGarvis.VocabularioGeneralGarvis;
import icaro.aplicaciones.recursos.comuGarvisChat.*;
import icaro.aplicaciones.recursos.comuGarvisChat.imp.InterpreteMsgsGARVIS;
import icaro.aplicaciones.recursos.comuGarvisChat.imp.util.ConexionGARVIS;
import icaro.aplicaciones.recursos.comuGarvisChat.imp.util.IrcException;
import icaro.aplicaciones.recursos.comuGarvisChat.imp.util.NickAlreadyInUseException;
import icaro.aplicaciones.recursos.extractorSemantico.ItfUsoExtractorSemantico;
import icaro.infraestructura.entidadesBasicas.interfaces.InterfazUsoAgente;
import icaro.infraestructura.patronRecursoSimple.imp.ImplRecursoSimple;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ClaseGeneradoraComuGarvisChat extends ImplRecursoSimple implements
		ItfUsoComuGarvisChat {

	private static final long serialVersionUID = 1L;
//	private ItfUsoRecursoTrazas trazas;
//	private ConsultaBBDD consulta;
//        private ComuGarvisChatImp conexChat;
  private ConexionGARVIS conexChat ;
 // private GarvisUserChat garvisUCInterface;
  private InterpreteMsgsGARVIS interpreteMsgGarvis;
  private String identExtractorSem;
//  private String url = null;
//  private String nickname = null;
//  private String chanel="#kiwiirc-garvis";
  private String identInterlocutorPruebas = "pacopa";
  private Boolean conectado = false;
        

	public ClaseGeneradoraComuGarvisChat(String idInstanciaRecurso) throws Exception {
		
		super(idInstanciaRecurso);
// obtenemos las propiedades del recurso que deben estar definidas en las propiedades del recurso
//                ItfUsoConfiguracion config = (ItfUsoConfiguracion) repoIntfaces.obtenerInterfaz(NombresPredefinidos.ITF_USO+NombresPredefinidos.CONFIGURACION);
//			DescInstanciaRecursoAplicacion descRecurso = config.getDescInstanciaRecursoAplicacion(idInstanciaRecurso);
//			nombreBD = descRecurso.getValorPropiedad("MYSQL_NAME_BD");

//                url=ConfigInfoComuGarvisChat.urlFeeNode;
//                nickname=ConfigInfoComuGarvisChat.nicknameConexionAgte;
//                identAgenteAReportar = VocabularioGeneralGarvis.IdentAgenteAplicacionDialogoCitas;
                identExtractorSem = VocabularioGeneralGarvis.IdentRecursoExtractorSemantico;
		try {
//                        conexChat = new ComuGarvisChatImp(idInstanciaRecurso,url,nickname);
                    
    conexChat = new ConexionGARVIS();
    //garvisUCInterface = new GarvisUserChat();
    interpreteMsgGarvis = new InterpreteMsgsGARVIS(conexChat);
    conexChat.setInterpreteMsgs(interpreteMsgGarvis);
    trazas.aceptaNuevaTraza(new InfoTraza(this.getId(),
      "Creando el recurso "+idInstanciaRecurso,
        InfoTraza.NivelTraza.debug));

//           InterfazUsoAgente itfAgteControlador=(InterfazUsoAgente) this.repoIntfaces.obtenerInterfazUso(identAgenteAReportar);
//           if (itfAgteControlador == null){
//               this.wait(1000);
//               itfAgteControlador=(InterfazUsoAgente) this.repoIntfaces.obtenerInterfazUso(identAgenteAReportar);
//               this.generarErrorCreacionComponente("itfAgteControlador es null");
//           }
//           ItfUsoExtractorSemantico itfExtractorSem=(ItfUsoExtractorSemantico) this.repoIntfaces.obtenerInterfazUso(identExtractorSem);
//           if (itfExtractorSem == null){
//               this.generarErrorCreacionComponente("itfExtractorSemantico es null");
//           }
//           if (itfExtractorSem == null ||itfAgteControlador == null )throw new Exception();
//           interpreteMsgGarvis.setItfusoAgenteGestorDialogo(itfAgteControlador);
//           interpreteMsgGarvis.setItfusoRecExtractorSemantico(itfExtractorSem);
////            conexChat.conectar();
//            conexChat.setVerbose(true); //Debugging -> false
//            conectado=conexChat.isConnected();
//        while(!conectado)
//        {
//            try {
//                conexChat.connect(url);
//                conexChat.joinChannel(chanel);
//                conexChat.changeNick(nickname);
//                conectado= true;
////                this.sendMessage("pacopa2", "hola hola");
//            } catch (IOException ex) {
//                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
//            } catch (IrcException ex) {
//                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
//            } catch (NickAlreadyInUseException ex) {
//                Logger.getLogger(ConexionGARVIS.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }           
        
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
//    trazas.aceptaNuevaTraza(new InfoTraza(this.getId(),
//          "Terminando recurso",
//          InfoTraza.NivelTraza.debug));
  //  AccesoBBDD.desconectar();
      
    try {
      super.termina();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

//    public Boolean nuevaConexion (String urlNueva, String canal, String nick ){
//        
//        if(conectado){
//            if(this.url.equals(urlNueva))
//                if(!this.chanel.equals(canal))this.chanel=canal;
//                    return true;
//                }
//        this.url = urlNueva;
//        conexChat.connect(url);
//        this.chanel=canal;
//        conexChat.joinChannel(chanel);
//        this.nickname= nick;
//            try {
//                return conexChat.conectar(url,chanel,nickname);
//            } catch (Exception ex) {
//                Logger.getLogger(ClaseGeneradoraComuGarvisChat.class.getName()).log(Level.SEVERE, null, ex);
//            }
//    }
  //@Override
  public void enviarMensagePrivado( String mensaje)throws Exception{
      conexChat.sendMessage(mensaje);
  }
  //@Override
  public void desconectar( )throws Exception{
      conexChat.disconnect();
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
             interpreteMsgGarvis.setIdentAgenteGestorDialogo(VocabularioGeneralGarvis.IdentAgenteAplicacionDialogoCitas);
             interpreteMsgGarvis.setIdentConexion(VocabularioGeneralGarvis.IdentConexionAgte);
             //conexChat.setVerbose(true);
             //conectar( url, chanel, nickname);
         }
         } catch (Exception ex) {
              Logger.getLogger(ClaseGeneradoraComuGarvisChat.class.getName()).log(Level.SEVERE, null, ex);
          }
         
         
            conexChat.connect();
//            conexChat.setVerbose(true); //Debugging -> false
            conectado=true;//conexChat.isConnected();

    }
  }
 /*       //@Override
    public Boolean conectar( String urlaConectar, String canal, String nick)throws Exception{
//           conectado=conexChat.isConnected();
        if(conectado){
            if(this.url.equals(urlaConectar))
                if(!this.chanel.equals(canal))this.chanel=canal;
                    return true;
                }else conectado=false;
           
        while(!conectado)
        {
            try {
                conexChat.connect(url);
                conexChat.joinChannel(chanel);
                conexChat.changeNick(nickname);
                conectado= true;
//                this.sendMessage("pacopa2", "hola hola");
            } catch (IOException ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            } catch (IrcException ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            } catch (NickAlreadyInUseException ex) {
                Logger.getLogger(ConexionGARVIS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conectado;
    }*/
     /*   //@Override
        public void enviarMensageCanal( String mensaje)throws Exception{
            conexChat.sendMessage(chanel, mensaje);
        }*/
  
}