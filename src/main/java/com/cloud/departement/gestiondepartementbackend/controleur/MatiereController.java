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

import com.cloud.departement.gestiondepartementbackend.model.Matiere;
import com.cloud.departement.gestiondepartementbackend.repository.MatiereRepository;
import com.companyname.springbootcrudrest.exception.ResourceNotFoundException;

@RestController 
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class MatiereController {

	@Autowired
    private MatiereRepository matiereRepository;

    @GetMapping("/matieres")
    public List<Matiere> getAllMatieres() {
        return matiereRepository.findAll();
    }

    @GetMapping("/matieres/{id}")
    public ResponseEntity<Matiere> getMatiereById(@PathVariable(value = "id") Long matiereId)
        throws ResourceNotFoundException {
        Matiere matiere = matiereRepository.findById(matiereId)
          .orElseThrow(() -> new ResourceNotFoundException("Matiere not found for this id :: " + matiereId));
        return ResponseEntity.ok().body(matiere);
    }
    
    @PostMapping("/matieres")
    public Matiere createMatiere(@Valid @RequestBody Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    @PutMapping("/matieres/{id}")
    public ResponseEntity<Matiere> updateMatiere(@PathVariable(value = "id") Long matiereId,
         @Valid @RequestBody Matiere matiereDetails) throws ResourceNotFoundException {
        Matiere matiere = matiereRepository.findById(matiereId)
        .orElseThrow(() -> new ResourceNotFoundException("Matiere not found for this id :: " + matiereId));
        matiere.setNom(matiereDetails.getNom());
        matiere.setCoefficient(matiereDetails.getCoefficient());
        matiere.setNbrHeures(matiereDetails.getNbrHeures());
        final Matiere updatedMatiere = matiereRepository.save(matiere);
        return ResponseEntity.ok(updatedMatiere);
    }

    @DeleteMapping("/matieres/{id}")
    public Map<String, Boolean> deleteMatiere(@PathVariable(value = "id") Long matiereId)
         throws ResourceNotFoundException {
        Matiere matiere = matiereRepository.findById(matiereId)
       .orElseThrow(() -> new ResourceNotFoundException("Matiere not found for this id :: " + matiereId));

        matiereRepository.delete(matiere);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	
}
