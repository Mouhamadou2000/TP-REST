package Models;

public class Client {
	
	
	String nom;
	String prenom;
	public Client () {
		
	}
	
public Client (String nom ,String Prenom) {
	this.nom=nom;
	this.prenom=Prenom;
	}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}


}
