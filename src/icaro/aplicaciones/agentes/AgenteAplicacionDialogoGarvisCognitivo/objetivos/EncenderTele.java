package icaro.aplicaciones.agentes.AgenteAplicacionDialogoGarvisCognitivo.objetivos;

import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;

public class EncenderTele extends Objetivo {
    
    /** Crea una nueva instancia de DarAcceso */
	public boolean flag;
    public EncenderTele() {
        super.setgoalId("EncenderLaTele");
        this.flag=false;
    }
    public void Cambiarflag(){
    	this.flag=!(this.flag);
    }
    public boolean isFlag() {
        return flag;
    }
}
