package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class View_Accueil {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Accueil window = new View_Accueil();
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
	public View_Accueil() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("EMPRUNTER UN LIVRE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				View_EmprunterLivre e1 = new View_EmprunterLivre();
				e1.main(null);
				
			}
		});
		btnNewButton.setBounds(230, 94, 184, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESTITUER UN LIVRE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Restituer e2 = new View_Restituer();
				e2.main(null);
				frame.setVisible(false);
				
			}
		});
		
		
		btnNewButton_1.setBounds(21, 94, 184, 51);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Espace Adhérent");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_EspaceAdherent e3;
			e3 = new View_EspaceAdherent();
			View_EspaceAdherent.main(null);
			   frame.setVisible(false);
			
			
			}
		});
		btnNewButton_2.setBounds(116, 179, 198, 23);
		frame.getContentPane().add(btnNewButton_2);  
		
		JButton btnNewButton_3 = new JButton("Liste Livres");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IstLIvre e4 = new IstLIvre();
				e4.main(null);
				frame.setVisible(false);
				
				
				
			}
		});
		btnNewButton_3.setBounds(284, 22, 129, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\wijda\\OneDrive\\Images\\2702162.png"));
		lblNewLabel_1.setBounds(161, 34, 308, 149);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton lisetad = new JButton("Liste adhérents");
		lisetad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_ListeAdherents e5 = new View_ListeAdherents();
				e5.main(null);
				frame.setVisible(false);
			}
		});
		lisetad.setBounds(27, 22, 155, 23);
		frame.getContentPane().add(lisetad);
	}
}
