package model;
import java.sql.Date;
import java.util.ArrayList;


public class HISTORIQUE {
	private Date dateD;
	private Date dateF;
	private LIVRE livre;
    private ADHERENT adherent;
    
	public HISTORIQUE(Date dateD, Date dateF, LIVRE livre, ADHERENT adherent) {
		super();
		this.dateD = dateD;
		this.dateF = dateF;
		this.livre = livre;
		this.adherent = adherent;
	}

	public Date getDateD() {
		return dateD;
	}

	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}

	public Date getDateF() {
		return dateF;
	}

	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}

	public LIVRE getLivre() {
		return livre;
	}

	public void setLivre(LIVRE livre) {
		this.livre = livre;
	}

	public ADHERENT getAdherent() {
		return adherent;
	}

	public void setAdherent(ADHERENT adherent) {
		this.adherent = adherent;
	
			
			
		}
		
}
