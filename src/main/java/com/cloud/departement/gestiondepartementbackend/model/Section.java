package com.cloud.departement.gestiondepartementbackend.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "sections")
public class Section {
	private long id;
	private String Nom ;
	

	public Section() {
		  
    }
 
    public Section(String Nom) {
         this.Nom = Nom;
       
      
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
	 
	
	@Override
    public String toString() {
        return "Matiere [id=" + id + ", Nom=" + Nom + " ]";
    }

	
	

}
