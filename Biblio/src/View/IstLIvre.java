package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import Controller.mainMVC;

import javax.swing.ImageIcon;
import java.awt.List;

public class IstLIvre {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IstLIvre window = new IstLIvre();
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
	public IstLIvre() {
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
		
		
		
		List list = new List();
		list.setBounds(57, 67, 308, 161);
		frame.getContentPane().add(list);
		
		
		System.out.println(mainMVC.getM().getListLivre().size());
		
		for (int i=0;i!=mainMVC.getM().getListLivre().size();i++)
		{
			
			list.add(mainMVC.getM().getListLivre().get(i).Ligne());
		}
		
		JLabel lblNewLabel = new JLabel("Liste des Livres ");
		lblNewLabel.setBounds(171, 33, 159, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\wijda\\Downloads\\e2f59b5eb33b397fedf37f91daed6d0a.jpg"));
		lblNewLabel_1.setBounds(0, 0, 460, 289);
		frame.getContentPane().add(lblNewLabel_1);
		
	}
}
