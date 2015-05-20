package icaro.aplicaciones.agentes.AgenteAplicacionDialogoGarvisCognitivo.objetivos;

import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;

public class EncenderTele extends Objetivo {
    
    /** Crea una nueva instancia de DarAcceso */
	private boolean flag;
	private boolean flag1;
    public EncenderTele() {
        super.setgoalId("EncenderLaTele");
        this.flag=false;
        this.flag1=false;
    }
    public void Cambiarflag(){
    	this.flag=!(this.flag);
    }
    public boolean isFlag() {
        return flag;
    }
    public void Cambiarflag1(){
    	this.flag1=!(this.flag1);
    }
    public boolean isFlag1() {
        return flag1;
    }
}
