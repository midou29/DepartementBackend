package com.cloud.departement.gestiondepartementbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.departement.gestiondepartementbackend.model.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {

}
