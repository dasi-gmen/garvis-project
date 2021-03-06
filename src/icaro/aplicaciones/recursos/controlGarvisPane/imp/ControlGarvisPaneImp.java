/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icaro.aplicaciones.recursos.controlGarvisPane.imp;

import icaro.aplicaciones.recursos.controlGarvisPane.imp.util.ConexionCONTROL;
import icaro.infraestructura.entidadesBasicas.comunicacion.ComunicacionAgentes;
import icaro.infraestructura.entidadesBasicas.comunicacion.MensajeSimple;
import icaro.infraestructura.entidadesBasicas.excepciones.ExcepcionEnComponente;
import icaro.infraestructura.entidadesBasicas.interfaces.InterfazUsoAgente;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlGarvisPaneImp extends ConexionCONTROL{
    private String identRecurso;
   // private String url = null;
   // private String nickname = null;
  //  private String chanel="#kiwiirc-garvis";
  //  private Boolean conectado=false;
    //public InterfazUsoAgente itfUsoAgenteGestDialogo;
    private  String identificadorAgenteGestorDialogo;
    private ComunicacionAgentes comunicator;
    private MensajeSimple mensajeAenviar;
    public ControlGarvisPaneImp(String identRecurso,String url, String nickname) {
        comunicator = new ComunicacionAgentes(this.identRecurso);
    }
//    public void setItfUsoAgenteGestorDialogo(InterfazUsoAgente itfUsoAgenteDialogo){
//        this.itfUsoAgenteGestDialogo=itfUsoAgenteDialogo;
//    }
    public synchronized final void setIdentAgenteGestorDialogo(String identAgenteDialogo){
        this.identificadorAgenteGestorDialogo=identAgenteDialogo;
    }
    public synchronized final String getIdentAgenteGestorDialogo(){
        return identificadorAgenteGestorDialogo;
    }

    @Override
    public void onPrivateMessage(String sender, String login, String hostname, String message)
    {
        if ( getIdentAgenteGestorDialogo()!=null){
            mensajeAenviar = new MensajeSimple(message,sender,getIdentAgenteGestorDialogo());
            comunicator.enviarMsgaOtroAgente(mensajeAenviar);
        }
        else try {
            throw new ExcepcionEnComponente ("El identificador del Gestor de dialogo no esta definido",this.getClass().getSimpleName(),null);
        } catch (ExcepcionEnComponente ex) {
            Logger.getLogger(ControlGarvisPaneImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void onMessage(String chanel,String sender, String login, String hostname, String message)
    {
        this.log("chanel:"+chanel+" Sender :"+sender+ "hostname: "+hostname+ "mensaje :"+message);
        if ( getIdentAgenteGestorDialogo()!=null)comunicator.enviarInfoAotroAgente(sender+message, getIdentAgenteGestorDialogo());
        else try {
            throw new ExcepcionEnComponente ("El identificador del Gestor de dialogo no esta definido",this.getClass().getSimpleName(),null);
        } catch (ExcepcionEnComponente ex) {
            Logger.getLogger(ControlGarvisPaneImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
