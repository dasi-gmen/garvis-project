package icaro.aplicaciones.recursos.controlGarvisPane.imp.util;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;

public class GUIChampu extends JPanel {

	private static final long serialVersionUID = 1L;

	GUIChampu(){		
		
		this.setBorder(new TitledBorder(":::CHAMPÚ:::"));
		
		this.setLayout(null);
		
		JLabel lCapacidad= new JLabel("Capacidad:");
	    lCapacidad.setBounds(20,25,200,25);
        
	    JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 40, 10);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(20);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setLabelTable(slider.createStandardLabels(10));
        
        JLabel lbPorcCpacidad = new JLabel("50%");
        lbPorcCpacidad.setBounds(100,50,200,25);
        
        JButton btDispensar = new JButton("Dispensar");		
        btDispensar.setBounds(60,100,100,25);
        
        JLabel lbMarca= new JLabel("Marca:");
        lbMarca.setBounds(20,125,200,25);
        

        JComboBox<String> cbMarca = new JComboBox<String>();
        cbMarca.addItem("Pantene");
        cbMarca.addItem("Loreal Paris");
        cbMarca.addItem("Herbal essence");
        cbMarca.addItem("Garnier");
        cbMarca.addItem("Sunsilk");
        cbMarca.addItem("Sedal");
        cbMarca.setBounds(20,150,200,25);
        
		JButton btRellenar = new JButton("Rellenar");		
		btRellenar.setBounds(70,200,100,25);
        		
        //ADD
        this.add(lCapacidad);	
		this.add(lbPorcCpacidad);
		this.add(btDispensar);
		this.add(lbMarca);
		this.add(cbMarca);
		this.add(btRellenar);
	}
	
	
	
	
}
