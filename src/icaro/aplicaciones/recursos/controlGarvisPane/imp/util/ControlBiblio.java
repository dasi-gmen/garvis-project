package icaro.aplicaciones.recursos.controlGarvisPane.imp.util;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ControlBiblio extends JPanel {

	private static final long serialVersionUID = 1L;

	ControlBiblio(){		
		
		this.setBorder(new TitledBorder(":::BIBLIOTECA:::"));		
		this.setLayout(null);
		
		JTextField introDato = new JTextField(20);
		introDato.setBounds(20,25,200,20);
        
		JButton btAgregar = new JButton("Agregar");		
		btAgregar.setBounds(60,50,120,25);
		
		JTextArea taLibros = new JTextArea(5,10);
		JScrollPane scrollTALibro = new JScrollPane(taLibros);
		scrollTALibro.setBounds(20,100,200,80);
				
		JButton btOnOff = new JButton("On/Off");
		btOnOff.setBounds(70,200,100,25);
				
		this.add(introDato);
		this.add(btAgregar);
		this.add(scrollTALibro, BorderLayout.CENTER );
		this.add(btOnOff);
		
		
	}
}
