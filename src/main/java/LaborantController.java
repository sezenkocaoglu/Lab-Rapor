import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/laborant")
public class LaborantController {

    private final LaborantRepository laborantRepository;

    @Autowired
    public LaborantController(LaborantRepository laborantRepository) {
        this.laborantRepository = laborantRepository;
    }

    @GetMapping("/")
    public List<Laborant> getAllLaborants() {
        return laborantRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laborant> getLaborantById(@PathVariable Long id) {
        Optional<Laborant> laborant = laborantRepository.findById(id);
        return laborant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Laborant> createLaborant(@RequestBody Laborant laborant) {
        Laborant createdLaborant = laborantRepository.save(laborant);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLaborant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laborant> updateLaborant(@PathVariable Long id, @RequestBody Laborant laborantDetails) {
        Optional<Laborant> laborant = laborantRepository.findById(id);
        if (laborant.isPresent()) {
            laborant.get().setFirstName(laborantDetails.getFirstName());
            laborant.get().setLastName(laborantDetails.getLastName());
            laborant.get().setHospitalId(laborantDetails.getHospitalId());
            laborantRepository.save(laborant.get());
            return ResponseEntity.ok(laborant.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaborant(@PathVariable Long id) {
        Optional<Laborant> laborant = laborantRepository.findById(id);
        if (laborant.isPresent()) {
            laborantRepository.delete(laborant.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
