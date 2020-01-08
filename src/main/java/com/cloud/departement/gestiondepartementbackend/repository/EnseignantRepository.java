package com.cloud.departement.gestiondepartementbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloud.departement.gestiondepartementbackend.model.Enseignant;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long>{}
