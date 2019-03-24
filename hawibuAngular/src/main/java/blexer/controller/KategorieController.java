package blexer.controller;

import blexer.datalayer.model.Kategorie;
import blexer.datalayer.service.KategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KategorieController {

    @Autowired
    private KategorieService kategorieService;

    //Get all coins
    @GetMapping("/api/kategorie")
    public ResponseEntity<List<Kategorie>> list() {
        final List<Kategorie> list = kategorieService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/api/kategorie")
    public ResponseEntity<?> save(@RequestBody final Kategorie kategorie) {
        return ResponseEntity.ok().body(kategorieService.saveEntity(kategorie));
    }

    @GetMapping("/api/kategorie/{id}")
    public ResponseEntity<Kategorie> get(@PathVariable("id") final Integer id) {
        final Kategorie kategorie = kategorieService.getEntity(id);
        return ResponseEntity.ok().body(kategorie);
    }

    @PutMapping("/api/kategorie/")
    public ResponseEntity<?> update(@RequestBody final Kategorie kategorie) {
        kategorieService.updateEntity(kategorie);
        return ResponseEntity.ok().body("Kategorie successfully updated!");
    }

    @DeleteMapping("/api/kategorie/{kategorie}")
    public ResponseEntity<?> delete(@PathVariable("kategorie") final Kategorie kategorie) {
        kategorieService.deleteEntity(kategorie);
        return ResponseEntity.ok().body("Kategorie successfully deleted!");
    }
}
