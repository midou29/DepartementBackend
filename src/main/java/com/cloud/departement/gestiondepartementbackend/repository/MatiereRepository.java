package com.cloud.departement.gestiondepartementbackend.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.cloud.departement.gestiondepartementbackend.model.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {
	

}
