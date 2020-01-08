package com.cloud.departement.gestiondepartementbackend.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matieres")
public class Matiere {
	private long id;
	private String Nom ;
    private Integer coefficient;
    private Integer nbrHeures;
  
	
	public Matiere() {
		  
    }
 
    public Matiere(String Nom, Integer coefficient, Integer nbrHeures) {
         this.Nom = Nom;
        this.coefficient=coefficient;
        this.nbrHeures=nbrHeures;
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
    
    @Column(name = "Coefficient", nullable = false)
    public Integer getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(Integer coefficient) {
		this.coefficient = coefficient;
	}
	 @Column(name = "nombreHeures", nullable = false)
	 public Integer getNbrHeures() {
			return nbrHeures;
		}

		public void setNbrHeures(Integer nbrHeures) {
			this.nbrHeures = nbrHeures;
		}
		
		
		
		
		
		
	

	@Override
    public String toString() {
        return "Matiere [id=" + id + ", Nom=" + Nom + ", coefficient=" + coefficient + ", nbrHeures=" + nbrHeures + "]";
    }

	
	
	
}

