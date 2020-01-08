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

import com.cloud.departement.gestiondepartementbackend.model.Absence;
import com.cloud.departement.gestiondepartementbackend.repository.AbsenceRepository;
import com.companyname.springbootcrudrest.exception.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 

@RequestMapping("/api/v1")
public class AbsenceController {
	@Autowired
    private AbsenceRepository absenceRepository;

    @GetMapping("/absences")
    public List<Absence> getAllAbsences() {
        return absenceRepository.findAll();
    }

    @GetMapping("/absences/{id}")
    public ResponseEntity<Absence> getAbsenceById(@PathVariable(value = "id") Long absenceId)
        throws ResourceNotFoundException {
        Absence absence = absenceRepository.findById(absenceId)
          .orElseThrow(() -> new ResourceNotFoundException("Absence not found for this id :: " + absenceId));
        return ResponseEntity.ok().body(absence);
    }
    
    @PostMapping("/absences")
    public Absence createAbsence(@Valid @RequestBody Absence absence) {
        return absenceRepository.save(absence);
    }

    @PutMapping("/absences/{id}")
    public ResponseEntity<Absence> updateAbsence(@PathVariable(value = "id") Long absenceId,
         @Valid @RequestBody Absence absenceDetails) throws ResourceNotFoundException {
        Absence absence = absenceRepository.findById(absenceId)
        .orElseThrow(() -> new ResourceNotFoundException("Absence not found for this id :: " + absenceId));
        absence.setDateAbsence(absenceDetails.getDateAbsence());
       absence.setType(absenceDetails.getType());
       absence.setEtudiant(absenceDetails.getEtudiant());
       absence.setMatiere(absenceDetails.getMatiere());
      
       
        final Absence updatedAbsence = absenceRepository.save(absence);
        return ResponseEntity.ok(updatedAbsence);
    }

    @DeleteMapping("/absences/{id}")
    public Map<String, Boolean> deleteAbsence(@PathVariable(value = "id") Long absenceId)
         throws ResourceNotFoundException {
        Absence absence = absenceRepository.findById(absenceId)
       .orElseThrow(() -> new ResourceNotFoundException("Absence not found for this id :: " + absenceId));

        absenceRepository.delete(absence);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	

}
