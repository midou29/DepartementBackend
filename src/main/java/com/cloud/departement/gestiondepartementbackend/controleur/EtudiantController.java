package com.cloud.departement.gestiondepartementbackend.controleur;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.departement.gestiondepartementbackend.model.Etudiant;
import com.cloud.departement.gestiondepartementbackend.repository.EtudiantRepository;
import com.companyname.springbootcrudrest.exception.ResourceNotFoundException;


@CrossOrigin(origins = "http://localhost:4200")
@RestController 

@RequestMapping("/api/v1")
public class EtudiantController {
	
	@Autowired
    private EtudiantRepository etudiantRepository;

    @GetMapping("/etudiants")
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @GetMapping("/etudiants/{id}")
    public ResponseEntity<Etudiant> getEmployeeById(@PathVariable(value = "id") Long etudiantId)
        throws ResourceNotFoundException {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
          .orElseThrow(() -> new ResourceNotFoundException("Etudiant not found for this id :: " + etudiantId));
        return ResponseEntity.ok().body(etudiant);
    }
    
    @PostMapping("/etudiants")
    public Etudiant createEtudiant(@Valid @RequestBody Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @PutMapping("/etudiants/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable(value = "id") Long etudiantId,
         @Valid @RequestBody Etudiant etudiantDetails) throws ResourceNotFoundException {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
        .orElseThrow(() -> new ResourceNotFoundException("Etudiant not found for this id :: " + etudiantId));
        etudiant.setNom(etudiantDetails.getNom());
        etudiant.setPrenom(etudiantDetails.getPrenom());
        etudiant.setCIN(etudiantDetails.getCIN());
        etudiant.setEmail(etudiantDetails.getEmail());
        etudiant.setTelephone(etudiantDetails.getTelephone());
        etudiant.setSection(etudiantDetails.getSection());
        final Etudiant updatedEtudiant = etudiantRepository.save(etudiant);
        return ResponseEntity.ok(updatedEtudiant);
    }

    @DeleteMapping("/etudiants/{id}")
    public Map<String, Boolean> deleteEtudiant(@PathVariable(value = "id") Long etudiantId)
         throws ResourceNotFoundException {
        Etudiant etudiant = etudiantRepository.findById(etudiantId)
       .orElseThrow(() -> new ResourceNotFoundException("Etudiant not found for this id :: " + etudiantId));

        etudiantRepository.delete(etudiant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	
	

}
