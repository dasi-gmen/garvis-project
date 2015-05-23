package Interfaz;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class GUITele extends JPanel {

	private static final long serialVersionUID = 1L;

	GUITele(){		
		
		this.setBorder(new TitledBorder(":::TELEVISOR:::"));
		
		this.setLayout(null);
		
		JLabel labelCanal = new JLabel("Canal:");
		labelCanal.setBounds(20,25,200,20);
        

		JComboBox<String> comboCanales = new JComboBox<String>();
		comboCanales.addItem("Canal plus");
		comboCanales.addItem("CNN en español");
		comboCanales.addItem("BBC news");
		comboCanales.addItem("National geography");		
		comboCanales.setBounds(20,50,200,25);
        
		JLabel labelPrograma = new JLabel("Programa:");
		labelPrograma.setBounds(20,100,100,25);
        
		JTextArea taPrograma = new JTextArea(); 
		taPrograma.setBounds(20,125,200,25);
        
		JLabel tiempoMin = new JLabel("mm");
		tiempoMin.setBounds(80,150,100,25);
		
		JLabel dosPuntos = new JLabel(":");
		dosPuntos.setBounds(110,150,100,25);
		
		JLabel tiempoSeg = new JLabel("ss");
		tiempoSeg.setBounds(120,150,100,25);
		
		JButton btGrabar = new JButton("Grabar");
		btGrabar.setBounds(70,160,100,25);
		
		
		JButton btOnOff = new JButton("On/Off");
		btOnOff.setBounds(70,200,100,25);
		
		this.add(labelCanal);		
		this.add(comboCanales);
		
		this.add(labelPrograma);
		this.add(taPrograma);
		this.add(btGrabar);
		this.add(btOnOff);
		
	}
}
