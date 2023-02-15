package Controller;

import java.sql.SQLException;

import model.model;
import View.View_Accueil;

public class mainMVC {
	private static model m;
	
	
	public static model getM() {
		return m;
	}



	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		// TODO Auto-generated method stub
		System.out.println("main MVC");
		m =new model();
		m.getAll();
		/*
		System.out.println(m.getListLivre().size());
		for (int i=0;i<m.getListLivre().size();i++)
		{
			m.getListLivre().get(i).AFFICHER();
		}
		*/
		View_Accueil window = new View_Accueil();
	}

	
}
