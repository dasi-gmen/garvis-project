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

	public List<String> LibrosNuevos = new ArrayList<String>();
	
	
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

	public String obtenerLibros(String param,String nombrelibro) {
		
		String mensajeprev;
	
		if(param == "1"){
            LibrosNuevos.add(nombrelibro);
//           suppliesNames = op1.ListaLibros();
            String space = " , " ;
            mensajeprev = VocabularioGeneralGarvis.HasDichoBiblioteca2;
            String mensaje2 = VocabularioGeneralGarvis.PedirNuevoLibro;
            Iterator<String> iterator = LibrosNuevos.iterator();
           while (iterator.hasNext()) {
                  mensajeprev +=iterator.next()+ space;
           }
           mensajeprev += mensaje2;
            
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
