package com.cloud.departement.gestiondepartementbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloud.departement.gestiondepartementbackend.model.Absence;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long>{
	List<Absence> findByMatiereId(Long matiereId);
	List<Absence> findByEtudiantId(Long etudiantId);
	 Optional<Absence> findByIdAndMatiereId(Long id, Long matiereId);
	 Optional<Absence> findByIdAndEtudiantId(Long id, Long etudianteId);
	
}

