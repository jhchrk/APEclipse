package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.mainMVC;

import java.awt.List;

public class View_ListeAdherents {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_ListeAdherents window = new View_ListeAdherents();
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
	public View_ListeAdherents() {
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
		list.setBounds(50, 79, 319, 148);
		frame.getContentPane().add(list);
		
		
      System.out.println(mainMVC.getM().getListAdherent().size());
		
		for (int i=0;i!=mainMVC.getM().getListAdherent().size();i++)
		{
			list.add(mainMVC.getM().getListAdherent().get(i).Ligne());
		}
	
JLabel lblNewLabel = new JLabel("Liste des Adhérents : ");
lblNewLabel.setBounds(152, 44, 163, 14);
frame.getContentPane().add(lblNewLabel);
}};
