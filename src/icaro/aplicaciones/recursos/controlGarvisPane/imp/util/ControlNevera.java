package icaro.aplicaciones.recursos.controlGarvisPane.imp.util;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ControlNevera extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JTextField introDato;
	public JButton botonIntro;
	public JTextArea productos;
	public JScrollPane scrollProductos;
	public JButton botonSacar;

	ControlNevera(){		
		
		this.setBorder(new TitledBorder(":::NEVERA:::"));		
		this.setLayout(null);
		
		introDato = new JTextField(20);
		introDato.setBounds(20,25,200,20);

		botonIntro = new JButton("Introducir");   
		botonIntro.setBounds(60,50,120,25);

		productos = new JTextArea(5,10);
		scrollProductos = new JScrollPane(productos);
		scrollProductos.setBounds(20,100,200,80);

		botonSacar = new JButton("Sacar");    
		botonSacar.setBounds(70,200,100,25);
				
		this.add(introDato);		
		this.add(botonIntro);
		this.add(scrollProductos, BorderLayout.CENTER );
		this.add(botonSacar);	
		
		
	}

	public void meterComidaNevera(String string) {
		// TODO Auto-generated method stub
		
	}

	public boolean sacarComidaNevera(String string) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
