package blexer.controller;

import blexer.datalayer.model.Geschaeft;
import blexer.datalayer.service.GeschaeftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GeschaeftController {

    @Autowired
    private GeschaeftService geschaeftService;

    //Get all coins
    @GetMapping("/api/geschaeft")
    public ResponseEntity<List<Geschaeft>> list(){
        List<Geschaeft> list = geschaeftService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/api/geschaeft")
    public ResponseEntity<?> save(@RequestBody Geschaeft geschaeft){
        geschaeftService.saveEntity(geschaeft);
        return ResponseEntity.ok().body("Geschaeft created!");
    }

    @GetMapping("/api/geschaeft/{id}")
    public ResponseEntity<Geschaeft> get(@PathVariable("id") Integer id){
        final Geschaeft geschaeft = geschaeftService.getEntity(id);
        return ResponseEntity.ok().body(geschaeft);
    }

    @PutMapping("/api/geschaeft/")
    public ResponseEntity<?> update(@RequestBody Geschaeft geschaeft){
        geschaeftService.updateEntity(geschaeft);
        return ResponseEntity.ok().body("Geschaeft successfully updated!");
    }

    @DeleteMapping("/api/geschaeft/{geschaeft}")
    public ResponseEntity<?> delete(@PathVariable("geschaeft") Geschaeft geschaeft){
        geschaeftService.deleteEntity(geschaeft);
        return ResponseEntity.ok().body("Geschaeft successfully deleted!");
    }
}
