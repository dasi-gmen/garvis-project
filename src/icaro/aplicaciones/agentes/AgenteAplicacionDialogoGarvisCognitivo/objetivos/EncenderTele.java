package icaro.aplicaciones.agentes.AgenteAplicacionDialogoGarvisCognitivo.objetivos;

import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;

public class EncenderTele extends Objetivo {
    
    /** Crea una nueva instancia de DarAcceso */
	private boolean flagSintonizar;
	private boolean flagGrabar;
	private int contadorInfofalsa; 
    public EncenderTele() {
        super.setgoalId("EncenderLaTele");
        this.setContadorInfofalsa(0);
        this.flagSintonizar=false;
        this.flagGrabar=false;
    }
    public void Cambiarflag(){
    	this.flagSintonizar=!(this.flagSintonizar);
    }
    public boolean isFlag() {
        return flagSintonizar;
    }
    public void Cambiarflag1(){
    	this.flagGrabar=!(this.flagGrabar);
    }
    public boolean isFlag1() {
        return flagGrabar;
    }
	public int getContadorInfofalsa() {
		return contadorInfofalsa;
	}
	public void setContadorInfofalsa(int contadorInfofalsa) {
		this.contadorInfofalsa =+ contadorInfofalsa;
	}
}
