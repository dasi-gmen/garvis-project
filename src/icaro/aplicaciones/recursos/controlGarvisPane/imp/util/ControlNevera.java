package Interfaz;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class GUINevera extends JPanel {

	private static final long serialVersionUID = 1L;

//	GUINevera(){		
//		this.setBorder(new TitledBorder(":::NEVERA:::"));
//	
//		JTextField introDato = new JTextField(20);
//		introDato.setBounds(20,25,200,20);
//		JButton botonIntro = new JButton("Introducir");
//		
//		JTextArea listaProd = new JTextArea(5,10);
//		//listaProd.setSize(500, 300);
//		JScrollPane scroll = new JScrollPane( listaProd );
//		scroll.setBounds(20,100,200,80);
//		JButton botonSacar = new JButton("Sacar");		
//		this.add(introDato);		
//		this.add(botonIntro);
//		this.add(scroll, BorderLayout.CENTER );
//		this.add(botonSacar);		
//	}
	
	GUINevera(){		
		
		this.setBorder(new TitledBorder(":::NEVERA:::"));		
		this.setLayout(null);
		
		JTextField introDato = new JTextField(20);
		introDato.setBounds(20,25,200,20);
        
		JButton botonIntro = new JButton("Introducir");		
		botonIntro.setBounds(60,50,120,25);
		
		JTextArea productos = new JTextArea(5,10);
		JScrollPane scrollProductos = new JScrollPane(productos);
		scrollProductos.setBounds(20,100,200,80);
				
		JButton botonSacar = new JButton("Sacar");		
		botonSacar.setBounds(70,200,100,25);
				
		this.add(introDato);		
		this.add(botonIntro);
		this.add(scrollProductos, BorderLayout.CENTER );
		this.add(botonSacar);	
		
		
	}
	
	
	
	
}
