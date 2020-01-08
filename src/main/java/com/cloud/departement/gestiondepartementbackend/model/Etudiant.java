package com.cloud.departement.gestiondepartementbackend.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "etudiants")

public class Etudiant {
	private long id;
	private long CIN ;
	private String Nom;
    private String Prenom;
    private String Email;
    private long Telephone;
   
   
    private Section section;
    
 
    public Etudiant() {
  
    }
 
    public Etudiant(String Nom, String Prenom, long CIN ,String Email, long Telephone) {
         this.Nom = Nom;
         this.Prenom = Prenom;
         this.CIN=CIN;
         this.Email = Email;
         this.Telephone=Telephone;
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
    public void setNom(String Nom) {
        this.Nom = Nom;
    }
 
    @Column(name = "Prenom", nullable = false)
    public String getPrenom() {
        return Prenom;
    }
    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }
    
    @Column(name = "CIN", nullable = false, unique = true)
    public long getCIN() {
		return CIN;
	}
    public void setCIN(long cIN) {
		CIN = cIN;
	}
    
   
 
    @Column(name = "Email", nullable = false, unique=true)
    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
  
    @Column(name = "Telephone", nullable = false, unique=true)
    public long getTelephone() {
		return Telephone;
	}

	public void setTelephone(long telephone) {
		Telephone = telephone;
	}
	 @ManyToOne()
	    @JoinColumn(name = "section_id", referencedColumnName="id",nullable = false)
	
	 public Section getSection() {
	        return section;
	    }

	    public void setSection(Section section) {
	        this.section = section;
	    }
	
	
	

	@Override
    public String toString() {
        return "Etudiant [id=" + id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", CIN=" + CIN + ", Email=" + Email
       + " , Telephone=" + Telephone +  "]";
    }

}
