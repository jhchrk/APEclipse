package View;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.mainMVC;
import model.ADHERENT;

import javax.swing.JButton;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View_EspaceAdherent {

	protected static final Container TXThisto = null;
	private JFrame frame;
	private JTextField textFieldad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_EspaceAdherent window = new View_EspaceAdherent();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View_EspaceAdherent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N°Adhérent :");
		lblNewLabel.setBounds(33, 60, 109, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Prêts actuels :");
		lblNewLabel_2.setBounds(33, 142, 109, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textFieldad = new JTextField();
		textFieldad.setBounds(131, 57, 156, 20);
		frame.getContentPane().add(textFieldad);
		textFieldad.setColumns(10);
		
		JButton valider = new JButton("OK");

		valider.setBounds(310, 56, 89, 23);
		frame.getContentPane().add(valider);
		
		List TXThisto = new List();
		TXThisto.setBounds(131, 118, 227, 71);
		frame.getContentPane().add(TXThisto);
		
		JButton retour = new JButton("RETOUR");
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		retour.setBounds(310, 208, 89, 23);
		frame.getContentPane().add(retour);
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ADHERENT ad = mainMVC.getM().findadherent(textFieldad.getText());
				System.out.println(mainMVC.getM().getListLivre().size());

				for (int i = 0; i != ad.getListLivre().size(); i++) {
					TXThisto.add(ad.getListLivre().get(i).Ligne());
					
				}
			}
		});
	}
}
