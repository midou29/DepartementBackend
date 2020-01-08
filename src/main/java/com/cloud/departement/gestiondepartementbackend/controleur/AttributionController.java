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

import com.cloud.departement.gestiondepartementbackend.model.Attribution;
import com.cloud.departement.gestiondepartementbackend.repository.AttributionRepository;
import com.companyname.springbootcrudrest.exception.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 

@RequestMapping("/api/v1")
public class AttributionController {
	@Autowired
    private AttributionRepository attributionRepository;

    @GetMapping("/attributions")
    public List<Attribution> getAllAttributions() {
        return attributionRepository.findAll();
    }

    @GetMapping("/attributions/{id}")
    public ResponseEntity<Attribution> getAttributionById(@PathVariable(value = "id") Long attributionId)
        throws ResourceNotFoundException {
    	Attribution attribution = attributionRepository.findById(attributionId)
          .orElseThrow(() -> new ResourceNotFoundException("attribution not found for this id :: " + attributionId));
        return ResponseEntity.ok().body(attribution);
    }
    
    @PostMapping("/attributions")
    public Attribution createAbsence(@Valid @RequestBody Attribution attribution) {
        return attributionRepository.save(attribution);
    }

    @PutMapping("/attributions/{id}")
    public ResponseEntity<Attribution> updateAttribution(@PathVariable(value = "id") Long attributionId,
         @Valid @RequestBody Attribution attributionDetails) throws ResourceNotFoundException {
    	Attribution attribution = attributionRepository.findById(attributionId)
        .orElseThrow(() -> new ResourceNotFoundException("attribution not found for this id :: " + attributionId));
     
    	attribution.setEnseignant(attributionDetails.getEnseignant());
    	attribution.setMatiere(attributionDetails.getMatiere());
      
       
        final Attribution updatedAttribution = attributionRepository.save(attribution);
        return ResponseEntity.ok(updatedAttribution);
    }

    @DeleteMapping("/attributions/{id}")
    public Map<String, Boolean> deleteAttribution(@PathVariable(value = "id") Long attributionId)
         throws ResourceNotFoundException {
    	Attribution attribution = attributionRepository.findById(attributionId)
       .orElseThrow(() -> new ResourceNotFoundException("attribution not found for this id :: " + attributionId));

    	attributionRepository.delete(attribution);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	

}
