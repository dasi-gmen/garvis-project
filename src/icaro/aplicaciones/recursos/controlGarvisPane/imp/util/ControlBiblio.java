package icaro.aplicaciones.recursos.controlGarvisPane.imp.util;

import icaro.aplicaciones.informacion.gestionGarvis.VocabularioGeneralGarvis;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

	public ArrayList<String> LibrosNuevos = new ArrayList<String>();
	
	public JTextField introDato ;
	public JButton btAgregar ;
	public JTextArea taLibros ;
	public JScrollPane scrollTALibro ;
	public JButton btOnOff ;
	
	ControlBiblio(){		
		
		this.setBorder(new TitledBorder(":::BIBLIOTECA:::"));		
		this.setLayout(null);
		
		introDato = new JTextField(20);
		introDato.setBounds(20,25,200,20);
		    
		btAgregar = new JButton("Agregar");   
		btAgregar.setBounds(60,50,120,25);

		taLibros = new JTextArea(5,10);
		scrollTALibro = new JScrollPane(taLibros);
		scrollTALibro.setBounds(20,100,200,80);
		    
		btOnOff = new JButton("On/Off");
		btOnOff.setBounds(70,200,100,25);
				
		this.add(introDato);
		this.add(btAgregar);
		this.add(scrollTALibro, BorderLayout.CENTER );
		this.add(btOnOff);
		
		
	}

	public String obtenerLibros(String param,String nombrelibro) {
		
		String mensajeprev;
	
		if(param == "1"){
            LibrosNuevos.add(nombrelibro);
            
            
            String listaLibrosString = "";
            //taLibros.append(nombrelibro+"\n");
//           suppliesNames = op1.ListaLibros();
            String space = " , " ;
            mensajeprev = VocabularioGeneralGarvis.HasDichoBiblioteca2;
            String mensaje2 = VocabularioGeneralGarvis.PedirNuevoLibro;
            Iterator<String> iterator = LibrosNuevos.iterator();
           while (iterator.hasNext()) {
        	   		String libro = iterator.next();
                  mensajeprev +=libro+ space;
                  listaLibrosString+=libro+"\n";
           }
           mensajeprev += mensaje2;
           
           taLibros.setText(listaLibrosString);
            
           }else{
            	mensajeprev = "Libro Encontrado . Buen Provecho"; //VocabularioGeneralGarvis.HasDichoBiblioteca2;
                String mensaje2 = VocabularioGeneralGarvis.PedirNuevoLibro;
//                suppliesNames2=op1.ListaLibros();
                Iterator<String> iterator = LibrosNuevos.iterator();
               while (iterator.hasNext()) {
            	   if(nombrelibro.equals(iterator.next()) ){
            		   String mensaje = "Encontrado";
            		   mensajeprev = mensaje ;
            		    
            	   }
            	   else{
            		   String mensaje = "Libro No encontrado";
            		   mensajeprev = mensaje ;
            	   }
               }
               if (LibrosNuevos.size()== 0){
            	   mensajeprev = "No has metido nada";
               } 
           	}
		
		return (mensajeprev);
	}
}
