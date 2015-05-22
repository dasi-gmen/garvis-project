package icaro.aplicaciones.agentes.AgenteAplicacionDialogoGarvisCognitivo.objetivos;

import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;

public class EncenderTele extends Objetivo {
    
    /** Crea una nueva instancia de DarAcceso */
	private boolean flagSintonizar;
	private boolean flagGrabar;
	private int contarPeticion;
	public EncenderTele() {
        super.setgoalId("EncenderLaTele");
        this.flagSintonizar=false;
        this.flagGrabar=false;
        this.contarPeticion=0;
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
	public int getContarPeticion() {
		return contarPeticion;
	}
	public void setContarPeticion(int contarPeticion) {
		this.contarPeticion = contarPeticion;
	}
	public void sumContarPeticion() {
		this.contarPeticion ++;
	}
}
