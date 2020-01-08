package com.cloud.departement.gestiondepartementbackend.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "absences")
public class Absence {
	private long id;
	 private Etudiant etudiant ;
	 private Matiere matiere ;
	 private String dateAbsence ;
	 private String type ;
	 public Absence() {
		  
	    }
	 
	 public Absence (String dateAbsence, String type) {
         this.dateAbsence = dateAbsence;
         this. type =  type;
       
    } 
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	        public long getId() {
	        return id;
	    }
	    public void setId(long id) {
	        this.id = id;
	    }
		 @ManyToOne()
		    @JoinColumn(name = "etudiant_id", referencedColumnName="id",nullable = false)

		public Etudiant getEtudiant() {
			return etudiant;
		}

		public void setEtudiant(Etudiant etudiant) {
			this.etudiant = etudiant;
		}
		 @ManyToOne()
		    @JoinColumn(name = "matiere_id", referencedColumnName="id",nullable = false)

		public Matiere getMatiere() {
			return matiere;
		}

		public void setMatiere(Matiere matiere) {
			this.matiere = matiere;
		}
		
		  @Column(name = "date_absence", nullable = false)
		  
		 
		public String getDateAbsence() {
			return dateAbsence;
		}

		public void setDateAbsence(String dateAbsence) {
			this.dateAbsence = dateAbsence;
		}
		  @Column(name = "type_seance", nullable = false, unique=true)
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	 
		@Override
	    public String toString() {
	        return "Absence [id=" + id + " , type=" + type + " , dateAbsence=" + dateAbsence+" ]";
	    }
	 
	 
	 

}
