package com.cloud.departement.gestiondepartementbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.departement.gestiondepartementbackend.model.Attribution;

public interface AttributionRepository extends JpaRepository<Attribution, Long>{ 

	List<Attribution> findByMatiereId(Long matiereId);
	List<Attribution> findByEnseignantId(Long enseignantId);
	 Optional<Attribution> findByIdAndMatiereId(Long id, Long matiereId);
	 Optional<Attribution> findByIdAndEnseignantId(Long id, Long enseignantId);
	
}
