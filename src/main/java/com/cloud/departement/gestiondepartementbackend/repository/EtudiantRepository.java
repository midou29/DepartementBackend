package com.cloud.departement.gestiondepartementbackend.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloud.departement.gestiondepartementbackend.model.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{
	List<Etudiant> findBySectionId(Long sectionId);
	 Optional<Etudiant> findByIdAndSectionId(Long id, Long sectionId);
	
	
}
