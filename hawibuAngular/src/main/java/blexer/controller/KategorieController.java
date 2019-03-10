package blexer.controller;

import blexer.datalayer.model.Kategorie;
import blexer.datalayer.service.KategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KategorieController {

    @Autowired
    private KategorieService kategorieService;

    //Get all coins
    @GetMapping("/api/kategorie")
    public ResponseEntity<List<Kategorie>> list(){
        List<Kategorie> list = kategorieService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/api/kategorie")
    public ResponseEntity<?> save(@RequestBody Kategorie kategorie){
        kategorieService.saveEntity(kategorie);
        return ResponseEntity.ok().body("Kategorie created!");
    }

    @GetMapping("/api/kategorie/{id}")
    public ResponseEntity<Kategorie> get(@PathVariable("id") Integer id){
        final Kategorie kategorie = kategorieService.getEntity(id);
        return ResponseEntity.ok().body(kategorie);
    }

    @PutMapping("/api/kategorie/")
    public ResponseEntity<?> update(@RequestBody Kategorie kategorie){
        kategorieService.updateEntity(kategorie);
        return ResponseEntity.ok().body("Kategorie successfully updated!");
    }

    @DeleteMapping("/api/kategorie/{kategorie}")
    public ResponseEntity<?> delete(@PathVariable("kategorie") Kategorie kategorie){
        kategorieService.deleteEntity(kategorie);
        return ResponseEntity.ok().body("Kategorie successfully deleted!");
    }
}
