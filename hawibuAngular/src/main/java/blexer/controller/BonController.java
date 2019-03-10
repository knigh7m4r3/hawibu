package blexer.controller;

import blexer.datalayer.model.Bon;
import blexer.datalayer.service.BonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BonController {

    @Autowired
    private BonService bonService;

    //Get all coins
    @GetMapping("/api/bon")
    public ResponseEntity<List<Bon>> list(){
        List<Bon> list = bonService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/api/bon")
    public ResponseEntity<?> save(@RequestBody Bon bon){
        bonService.saveEntity(bon);
        return ResponseEntity.ok().body("Bon created!");
    }

    @GetMapping("/api/bon/{id}")
    public ResponseEntity<Bon> get(@PathVariable("id") Integer id){
        final Bon bon = bonService.getEntity(id);
        return ResponseEntity.ok().body(bon);
    }

    @PutMapping("/api/bon/")
    public ResponseEntity<?> update(@RequestBody Bon bon){
        bonService.updateEntity(bon);
        return ResponseEntity.ok().body("Bon successfully updated!");
    }

    @DeleteMapping("/api/bon/{bon}")
    public ResponseEntity<?> delete(@PathVariable("bon") Bon bon){
        bonService.deleteEntity(bon);
        return ResponseEntity.ok().body("Bon successfully deleted!");
    }
}
