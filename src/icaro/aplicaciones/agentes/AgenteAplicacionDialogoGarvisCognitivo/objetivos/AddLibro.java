package icaro.aplicaciones.agentes.AgenteAplicacionDialogoGarvisCognitivo.objetivos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import java.util.List;
import java.util.ArrayList;

public class AddLibro extends Objetivo {
	
	public List<String> LibrosNuevos = new ArrayList<String>();
	public boolean extract ;
	public AddLibro() {
		super.setgoalId("AddLibro");
	}
	public List ListaLibros() {
		return LibrosNuevos;
	}

	public void SumarLibro(String libro) {

		this.LibrosNuevos.add(libro); 
	}
	
}
