package com.cloud.departement.gestiondepartementbackend.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enseignants")
public class Enseignant {
	private long id;
	private String Nom;
    private String Prenom;
    private String Email;
    private long contact;
    
    
    public Enseignant() {
    	  
    }
 
    public Enseignant(String Nom, String Prenom ,String Email, long contact) {
         this.Nom = Nom;
         this.Prenom = Prenom;
         this.contact=contact;
         this.Email = Email;
         
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name = "Nom", nullable = false)
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	  @Column(name = "Prenom", nullable = false)
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	 @Column(name = "Email", nullable = false, unique=true)
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	 @Column(name = "contact", nullable = false, unique=true)
	
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	@Override
    public String toString() {
        return "Enseignant [id=" + id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Email=" + Email
       + " , contact=" + contact +  "]";
    }
	
	
}
