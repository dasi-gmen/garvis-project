package icaro.aplicaciones.recursos.controlGarvisPane.imp.util;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.Element;

public class GarvisUserControl extends JFrame {
	
	JTextArea areaCodigo =new JTextArea("");	
	JLabel lineaColumnaAreaCodigo = new JLabel("Posici�n del puntero :  (0,0)");
	JTextArea areaIn = new JTextArea("Aqu� se escriben las entradas",2,5);	
	
	public ControlNevera nevera;
	public ControlMicroondas microondas;
	public ControlTele tele;
	public ControlBiblio biblio;
	public ControlChampu champu;
	public ControlAspiradora aspiradora;
	public ControlTermostato termostato;
	public ControlDetector detector;
	
	
	
	
	private static final long serialVersionUID = 1L;

	public GarvisUserControl() {
		inicializarInterfaz();  
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				System.exit(0);
			}
		});

	}

	public void inicializarInterfaz() {
		this.setContentPane(getPanelPrincipal());
		this.setTitle("GARVIS CONTROL");
	}
	
	private JPanel getPanelPrincipal() {
		JPanel panelPrincipal = new JPanel();
		BorderLayout b = new BorderLayout();
		panelPrincipal.setLayout(b);
		
			JPanel panelControl = new JPanel(new GridLayout(1,3));			
			panelControl.add(construyeAreaLenguajeP());
			panelPrincipal.add("Center",panelControl);
		return panelPrincipal;
	}
	
	
	public JPanel construyeAreaLenguajeP(){
		
		JPanel panelRecursos = new JPanel();
		panelRecursos.setLayout(new GridLayout(2,4)); 
		nevera= new ControlNevera();
		microondas= new ControlMicroondas();
		tele= new ControlTele();
		biblio= new ControlBiblio();
		champu= new ControlChampu();
		aspiradora= new ControlAspiradora();
		termostato= new ControlTermostato();
		detector= new ControlDetector();
		
		panelRecursos.add(nevera);
		panelRecursos.add(microondas); 
		panelRecursos.add(tele);
		panelRecursos.add(biblio);
		panelRecursos.add(champu);
		panelRecursos.add(aspiradora);
		panelRecursos.add(termostato);
		panelRecursos.add(detector);
		
		return panelRecursos;
		
	}
	
	


	
	
	public void oyenteEjecutar(final JButton ejecutarButton){
		ejecutarButton.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			if(ejecutarButton==e.getSource()){			
				
				System.out.print("Hola");
				//sintactico.comenzarAnalisisSintactico();
				
					//buscarEntradas();	
							
			}
			
		}});
	}
	
	
	public JPanel construyeAreaIn(){
		JPanel outPPanel = new JPanel();
		//outPPanel.setBorder(new TitledBorder("Entrada:"));
		
		BorderLayout bl = new BorderLayout();
		outPPanel.setBorder(new TitledBorder("Entrada:"));
		outPPanel.setLayout(bl);		
	
		
		areaIn.setFont(new Font("Calibri", Font.PLAIN, 15));
		JScrollPane scroll = new JScrollPane( areaIn );
				
		outPPanel.add("Center", scroll);
		
		return outPPanel;
		
	}	


	
		
	JMenuItem getSalirItem() {
		JMenuItem salirItem = new JMenuItem();
		salirItem.setText("Salir");
		salirItem.setMnemonic('S');
		salirItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,Event.CTRL_MASK));		

		salirItem.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){								
			if(JOptionPane.showConfirmDialog(JOptionPane.getFrameForComponent(getParent()),
					"�Est� seguro que quiere cerrar?","Mensaje",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){					 
				System.exit(1);
				}
			}});	

		return salirItem;		
	}

	
	// Clase para el contador linea/columna
	class CaretList implements CaretListener {
        
        public CaretList(JTextArea textoEntrada)
        {
        	areaCodigo = textoEntrada;
        }
       
        public void caretUpdate(CaretEvent arg0) {
            int caretPosition = areaCodigo.getCaretPosition();
            Element root = areaCodigo.getDocument().getDefaultRootElement();//areaCodigo.getDocument().getDefaultRootElement();
            
            int linea = root.getElementIndex(caretPosition);      
            int lineStart = root.getElement(linea).getStartOffset();
            int columna = (caretPosition - lineStart);            
            lineaColumnaAreaCodigo.setText("Posici�n del puntero :  ("+Integer.toString(linea)+","+String.valueOf(columna)+")");       
           
        }       
    }
	
	
	
	
	public static GarvisUserControl start() {
		
		GarvisUserControl interfaz = new GarvisUserControl();
		
		interfaz.setVisible(true);
		interfaz.setEnabled(true);
		interfaz.setSize(1000, 600);
		interfaz.setResizable(false);
		//interfaz.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		return interfaz;
		
	}

}
