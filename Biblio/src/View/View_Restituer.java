package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.mainMVC;
import model.LIVRE;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class View_Restituer {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JLabel lbl_info_livre;
	private JButton restituer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Restituer window = new View_Restituer();
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
	public View_Restituer() {
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
		
		JLabel lblNewLabel = new JLabel("ISBN du livre a restituer :");
		lblNewLabel.setBounds(45, 55, 241, 74);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(31, 121, 163, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lbl_info_livre = new JLabel("");
		lbl_info_livre.setBounds(84, 200, 163, 14);
		frame.getContentPane().add(lbl_info_livre);
		
		
		JButton btnNewButton = new JButton("VALIDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LIVRE l;
				l=mainMVC.getM().findlivre(textField.getText());
				if(l==null)
				{
					lbl_info_livre.setText("Livre non trouvé");
				}
				else
				{
					if(l.getEmprunteur()==null)
					{
						
					
						lbl_info_livre.setText("Erreur ");

					}
					else
					{
						lbl_info_livre.setText(l.getTitre());
						btnNewButton.setEnabled(true);
						lbl_info_livre.setEnabled(false);
						
						try {
							mainMVC.getM().restituer_livre(textField.getText());
							btnNewButton.setEnabled(false);
							lbl_info_livre.setText("le livre a bien été restituer");
						}
						catch(SQLException e1){
							e1.printStackTrace();
						}
					}
				}
			}
		});
				
			
		btnNewButton.setBounds(74, 166, 77, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\wijda\\OneDrive\\Images\\1492807.png"));
		lblNewLabel_2.setBounds(247, 57, 179, 141);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\wijda\\Downloads\\e2f59b5eb33b397fedf37f91daed6d0a.jpg"));
		lblNewLabel_1.setBounds(-13, 11, 474, 278);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
