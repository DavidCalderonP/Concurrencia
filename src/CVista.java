import javax.swing.*;
import java.awt.*;

public class CVista extends JFrame{

    JComboBox<String> jcbChequera;
    JLabel lblChequera, lblImporte;
    JTextField txtFldImporte;
    JPanel jpCentro, jpSur;
    JButton btnRetirar;
    String[] chequeras = new String[]{"CHEQ001", "CHEQ002", "CHEQ003", "CHEQ004", "CHEQ005"};

    CVista(){
        super("Concurrencia");
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int height = pantalla.height;
		int width = pantalla.width;
		setSize((width / 3), (height / 3));
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jpCentro = new JPanel();
		jpCentro.setLayout(new GridLayout(0, 2));
		txtFldImporte = new JTextField();
        jcbChequera = new JComboBox<String>(chequeras);
		btnRetirar = new JButton("Confirmar retiro");
		jpCentro.add(new JLabel("Número de Chequera"));
		jpCentro.add(jcbChequera);
		jpCentro.add(new JLabel("Monto a retirar"));
		jpCentro.add(txtFldImporte);

		add(jpCentro, BorderLayout.CENTER);

		jpSur = new JPanel();
		jpSur.add(btnRetirar);
        add(jpSur, BorderLayout.SOUTH);
        setVisible(true);
        
    }

}
