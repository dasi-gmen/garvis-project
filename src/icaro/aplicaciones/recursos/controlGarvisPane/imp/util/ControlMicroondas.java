package Interfaz;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class GUIMicroondas extends JPanel {

	private static final long serialVersionUID = 1L;

	GUIMicroondas(){		
		
		this.setBorder(new TitledBorder(":::MICROONDAS:::"));
		
		this.setLayout(null);
		
		JTextField introDato = new JTextField(20);
		introDato.setBounds(20,25,200,20);
        
		JButton botonAbirCerrar = new JButton("Abrir/Cerrar");		
		botonAbirCerrar.setBounds(60,50,120,25); 	
        
		JLabel potencia = new JLabel("Potencia:");
		potencia.setBounds(20,100,100,25);
		
		JComboBox<String> comboPotencias = new JComboBox<String>();
		comboPotencias.addItem("Defrost");
		comboPotencias.addItem("350 Watt");
		comboPotencias.addItem("500 Watt");
		comboPotencias.addItem("MAX");
		comboPotencias.setBounds(90,100,125,25);
		
		JLabel tiempoMin = new JLabel("mm");
		tiempoMin.setBounds(80,150,100,25);
		
		JLabel dosPuntos = new JLabel(":");
		dosPuntos.setBounds(110,150,100,25);
		
		JLabel tiempoSeg = new JLabel("ss");
		tiempoSeg.setBounds(120,150,100,25);
		
		JButton start = new JButton("Start");
		start.setBounds(70,200,100,25);
		
		this.add(introDato);		
		this.add(botonAbirCerrar);
		
		this.add(potencia);
		this.add(comboPotencias);
		this.add(tiempoMin);
		this.add(dosPuntos);
		this.add(tiempoSeg);
		
		this.add(start);
		
	}
	
	
	
	
}
