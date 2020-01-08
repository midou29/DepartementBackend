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

import com.cloud.departement.gestiondepartementbackend.model.Enseignant;
import com.cloud.departement.gestiondepartementbackend.repository.EnseignantRepository;
import com.companyname.springbootcrudrest.exception.ResourceNotFoundException;

@RestController 
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class EnseignantController {
	@Autowired
    private EnseignantRepository enseignantRepository;

    @GetMapping("/enseignants")
    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    @GetMapping("/enseignants/{id}")
    public ResponseEntity<Enseignant> getEnseignantById(@PathVariable(value = "id") Long enseignantId)
        throws ResourceNotFoundException {
        Enseignant enseignant = enseignantRepository.findById(enseignantId)
          .orElseThrow(() -> new ResourceNotFoundException("Enseignant not found for this id :: " + enseignantId));
        return ResponseEntity.ok().body(enseignant);
    }
    
    @PostMapping("/enseignants")
    public Enseignant createEnseignant(@Valid @RequestBody Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    @PutMapping("/enseignants/{id}")
    public ResponseEntity<Enseignant> updateEnseignant(@PathVariable(value = "id") Long enseignantId,
         @Valid @RequestBody Enseignant enseignantDetails) throws ResourceNotFoundException {
        Enseignant enseignant = enseignantRepository.findById(enseignantId)
        .orElseThrow(() -> new ResourceNotFoundException("Enseignant not found for this id :: " + enseignantId));
        enseignant.setNom(enseignantDetails.getNom());
        enseignant.setPrenom(enseignantDetails.getPrenom());
      
        enseignant.setEmail(enseignantDetails.getEmail());
        enseignant.setContact(enseignantDetails.getContact());
   
        final Enseignant updatedEnseignant = enseignantRepository.save(enseignant);
        return ResponseEntity.ok(updatedEnseignant);
    }

    @DeleteMapping("/enseignants/{id}")
    public Map<String, Boolean> deleteEnseignant(@PathVariable(value = "id") Long enseignantId)
         throws ResourceNotFoundException {
        Enseignant enseignant = enseignantRepository.findById(enseignantId)
       .orElseThrow(() -> new ResourceNotFoundException("Enseignant not found for this id :: " + enseignantId));

        enseignantRepository.delete(enseignant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	
	
}
