package blexer.controller;

import blexer.datalayer.model.Jahr;
import blexer.datalayer.model.Monat;
import blexer.datalayer.service.MonatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MonatController {

    @Autowired
    private MonatService monatService;

    //Get all coins
    @GetMapping("/api/monat")
    public ResponseEntity<List<Monat>> list(){
        List<Monat> list = monatService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/api/monat")
    public ResponseEntity<?> save(@RequestBody Monat monat){
        monatService.saveEntity(monat);
        return ResponseEntity.ok().body("Monat created!");
    }

    @GetMapping("/api/monat/{id}")
    public ResponseEntity<Monat> get(@PathVariable("id") Integer id){
        final Monat monat = monatService.getEntity(id);
        return ResponseEntity.ok().body(monat);
    }

    @PutMapping("/api/monat/")
    public ResponseEntity<?> update(@RequestBody Monat monat){
        monatService.updateEntity(monat);
        return ResponseEntity.ok().body("Monat successfully updated!");
    }

    @DeleteMapping("/api/monat/{monat}")
    public ResponseEntity<?> delete(@PathVariable("monat") Monat monat){
        monatService.deleteEntity(monat);
        return ResponseEntity.ok().body("Monat successfully deleted!");
    }

}
