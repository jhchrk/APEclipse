package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;



public class model {
	private Connection con;
	private ArrayList<LIVRE> ListLivre;
	private ArrayList<AUTEUR> ListAuteur;
	private ArrayList<ADHERENT> ListAdherent;

	public ArrayList<LIVRE> getListLivre() {
		return ListLivre;
	}
	
	public ArrayList<ADHERENT> getListAdherent() {
		return ListAdherent;
	}

	public void getAll() throws SQLException {
		ListAdherent.clear();
		ListAuteur.clear();
		ListLivre.clear();
		ListLivre=new ArrayList<LIVRE> ();
		ListAuteur=new ArrayList<AUTEUR> ();
		ListAdherent=new ArrayList<ADHERENT> ();

		ResultSet resultats;
		String requete;
		//*********************************************
		//CREATION DES AUTEURS
		//*********************************************
		requete = "SELECT * FROM auteur";


		Statement stmt = con.createStatement();
		resultats = stmt.executeQuery(requete);

		while (resultats.next()) {
			AUTEUR a=new AUTEUR(resultats.getString(1), resultats.getString(2), resultats.getString(3), resultats.getString(4),resultats.getString(5));
			ListAuteur.add(a);
		}



		//*********************************************
		//CREATION DES LIVRES
		//*********************************************
		requete = "SELECT * FROM livre";


		stmt = con.createStatement();
		resultats = stmt.executeQuery(requete);

		while (resultats.next()) {
			LIVRE l=new LIVRE(resultats.getString(1), resultats.getString(2), resultats.getInt(3));
			ListLivre.add(l);
		}



		//*********************************************
		//CREATION DES ADHERENTS
		//*********************************************
		requete = "SELECT * FROM adherent";


		stmt = con.createStatement();
		resultats = stmt.executeQuery(requete);

		while (resultats.next()) {
			ADHERENT ad=new ADHERENT(resultats.getString(1), resultats.getString(2),  resultats.getString(3), resultats.getString(4));
			ListAdherent.add(ad);
		}


		//*********************************************
		//AJOUT liste de livre e ADHERENT
		//AJOUT de l'emprunteur e LIVRE
		//*********************************************
		requete = "SELECT ISBN,adherent FROM livre, adherent WHERE livre.adherent = adherent.num";


		stmt = con.createStatement();
		resultats = stmt.executeQuery(requete);
		String ISBN,numadherent ;
		while (resultats.next()) {
			ISBN= resultats.getString(1);
			numadherent=resultats.getString(2);
			findlivre(ISBN).setEmprunteur(findadherent(numadherent));
			findadherent(numadherent).ajouterLivre(findlivre(ISBN));
		}



		//*********************************************
		//Ajout de l'auteur au LIVRE
		//*********************************************
		requete = "SELECT ISBN,auteur FROM livre, auteur WHERE livre.auteur = auteur.num";


		stmt = con.createStatement();
		resultats = stmt.executeQuery(requete);
		String numauteur ;
		while (resultats.next()) {
			ISBN= resultats.getString(1);
			numauteur=resultats.getString(2);
			findlivre(ISBN).setAuteur(findauteur(numauteur));

		}



		/*

		System.out.println("nb Livre :"+ListLivre.size());
		System.out.println("nb Adherent :"+ListAdherent.size());
		System.out.println("nb Auteur :"+ListAuteur.size());
		 */
		System.out.println("chargement BDD OK");

	}
	public AUTEUR findauteur(String num)
	{
		for(int i=0;i<ListAuteur.size();i++)
		{
			if(ListAuteur.get(i).getNum().equals(num))
			{
				return ListAuteur.get(i);
			}
		}

		return null;
	}

	public LIVRE findlivre(String ISBN)
	{
		for(int i=0;i<ListLivre.size();i++)
		{
			if(ListLivre.get(i).getISBN().equals(ISBN))
			{
				return ListLivre.get(i);
			}
		}

		return null;
	}
	public ADHERENT findadherent(String num)
	{
		for(int i=0;i<ListAdherent.size();i++)
		{
			if(ListAdherent.get(i).getNum().equals(num))
			{
				return ListAdherent.get(i);
			}
		}

		return null;
	}

	public void setListLivre(ArrayList<LIVRE> listLivre) {
		ListLivre = listLivre;
	}
	
	public void setListAdherent(ArrayList<ADHERENT> listadherent) {
		ListAdherent = listadherent;
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public model() {
		ListLivre=new ArrayList<LIVRE> ();
		ListAuteur=new ArrayList<AUTEUR> ();
		ListAdherent=new ArrayList<ADHERENT> ();
		String BDD = "AP2";
		String url = "jdbc:mysql://localhost:3306/" + BDD;
		String user = "root";
		String passwd = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, passwd);
			this.con = conn;
			System.out.println("Connection OK");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void emprunter_livre(String adherent, String livre) throws SQLException
	{		

		String requete;
		Statement stmt = con.createStatement();

		requete = "UPDATE livre set adherent="+adherent+" WHERE ISBN="+livre+";";
		stmt.executeUpdate(requete);





}
	public void restituer_livre(String l) throws SQLException
	{		

		String requete;
		Statement stmt = con.createStatement();
		
		requete = "UPDATE `livre` SET adherent = NULL WHERE `livre`.`ISBN` = "+l+";";
		System.out.println(requete);
		
		stmt.executeUpdate(requete);
		
	}

    public void nbr_livres(String l1) throws SQLException
    {
    	String requete;
    	Statement stmt = con.createStatement();
    
	requete = "SELECT COUNT(*) FROM livre WHERE adherent IS NOT null;";
	System.out.println(requete);
	
	stmt.executeUpdate(requete);
				
}

}



