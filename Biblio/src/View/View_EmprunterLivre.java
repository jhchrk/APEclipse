package View;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.mainMVC;
import model.ADHERENT;
import model.LIVRE;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class View_EmprunterLivre {

	protected static final Component Valider2 = null;
	private JFrame frame;
	private JTextField textfieldnumad;
	private JTextField textFieldisbn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_EmprunterLivre window = new View_EmprunterLivre();
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
	public View_EmprunterLivre() {
		try {
			mainMVC.getM().getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		JLabel emprunter = new JLabel("EMPRUNTER");
		emprunter.setBounds(164, 45, 81, 14);
		frame.getContentPane().add(emprunter);
		
		JLabel lblNAdherent = new JLabel("N° Adherent :");
		lblNAdherent.setBounds(45, 85, 75, 14);
		frame.getContentPane().add(lblNAdherent);
		
		textfieldnumad = new JTextField();
		textfieldnumad.setBounds(151, 82, 96, 20);
		frame.getContentPane().add(textfieldnumad);
		textfieldnumad.setColumns(10);
		
		JButton Valider1 = new JButton("Valider");

		Valider1.setBounds(268, 81, 89, 23);
		frame.getContentPane().add(Valider1);
		
		JLabel lblNewLabel = new JLabel("N°ISBN livre :");
		lblNewLabel.setBounds(52, 156, 81, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldisbn = new JTextField();
		textFieldisbn.setBounds(149, 153, 96, 20);
		frame.getContentPane().add(textFieldisbn);
		textFieldisbn.setColumns(10);
		
		JButton Valider2 = new JButton("Valider");
	
			
		Valider2.setEnabled(false);
		Valider2.setBounds(268, 152, 89, 23);
		frame.getContentPane().add(Valider2);
		
		JLabel lbl_info_ad = new JLabel("");
		lbl_info_ad.setBounds(112, 115, 169, 14);
		frame.getContentPane().add(lbl_info_ad);
		
	
	
		
		JLabel lbl_info_fin = new JLabel("");
		lbl_info_fin.setBounds(74, 238, 207, 14);
		frame.getContentPane().add(lbl_info_fin);
		
		JLabel lbl_info_livre = new JLabel("");
		lbl_info_livre.setBounds(94, 184, 210, 14);
		frame.getContentPane().add(lbl_info_livre);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\wijda\\OneDrive\\Images\\2417787.png"));
		lblNewLabel_1.setBounds(327, 35, 135, 138);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\wijda\\Downloads\\e2f59b5eb33b397fedf37f91daed6d0a.jpg"));
		lblNewLabel_2.setBounds(-66, 2, 631, 311);
		frame.getContentPane().add(lblNewLabel_2);
		
		Valider2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LIVRE l;
				l=mainMVC.getM().findlivre(textFieldisbn.getText());
			
				if(l==null)
				{
					lbl_info_livre.setText("Livre non trouvé");
				}
				else
				{
					if(l.getEmprunteur()==null)
					{
						lbl_info_livre.setText(l.getTitre());
					    
						lbl_info_livre.setEnabled(false);
						
						try {
						mainMVC.getM().emprunter_livre(textfieldnumad.getText(), textFieldisbn.getText());
						Valider2.setEnabled(false);
						
						lbl_info_fin.setText("Le livre a bien été emprunté");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
}
					else
					{
						lbl_info_livre.setText("Erreur Livre indisponible");
						
					}	
				
				
				
			}
			}
		});
		JButton reserver = new JButton("Réserver");
		reserver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mainMVC.getM().emprunter_livre(textfieldnumad.getText(), textFieldisbn.getText());
					reserver.setEnabled(false);
					
					lbl_info_fin.setText("Le livre a bien été emprunté");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			
			}
		});
		
		Valider1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ADHERENT ad;
			ad=mainMVC.getM().findadherent(textfieldnumad.getText());
			if(ad==null)
			{
				lbl_info_ad.setText("Adhérent non trouvé!");
			
			}
			else
			{
			
				textfieldnumad.setEnabled(false);
				lbl_info_ad.setText("Nom adhérent : "+ad.getNom());
				textFieldisbn.setEnabled(true);
				Valider2.setEnabled(true);
	
				lbl_info_livre.setText("Veuillez entrer un numéro d'ISBN a reserver");
			}}
			
		});
		
		
		
		
		
	}
}
