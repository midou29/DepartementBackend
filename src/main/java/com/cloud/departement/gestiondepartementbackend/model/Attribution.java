package com.cloud.departement.gestiondepartementbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attribution_prof_matiere")
public class Attribution {
	private long id;
	private Enseignant enseignant;
	private Matiere matiere ;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
 
    @ManyToOne()
    @JoinColumn(name = "enseignant_id", referencedColumnName="id",nullable = false)

public Enseignant getEnseignant() {
	return enseignant;
}

public void setEnseignant(Enseignant enseignant) {
	this.enseignant = enseignant;
}
  
@ManyToOne()
@JoinColumn(name = "matiere_id", referencedColumnName="id",nullable = false)

public Matiere getMatiere() {
return matiere;
}

public void setMatiere(Matiere matiere) {
this.matiere = matiere;
}
    
@Override
public String toString() {
    return "Attribution [id=" + id + "]";
}

    
    

}
