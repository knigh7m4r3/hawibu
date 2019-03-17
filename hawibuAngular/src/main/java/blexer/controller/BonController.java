package blexer.controller;

import blexer.datalayer.model.Bon;
import blexer.datalayer.model.Jahr;
import blexer.datalayer.model.Monat;
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
        final Bon newBon = bonService.saveEntity(bon);
        return ResponseEntity.ok().body(newBon);
    }

    @GetMapping("/api/bon/{id}")
    public ResponseEntity<Bon> get(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(bonService.getEntity(id));
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

    @GetMapping("/api/bon/byMonat/{monat}")
    public ResponseEntity getByMonat(@PathVariable("monat") String monat){
        final List<Bon> list = bonService.getByMonat(monat);
        return ResponseEntity.ok().body(list);

    }

    @GetMapping("/api/bon/byJahr/{jahr}")
    public ResponseEntity getByJahr(@PathVariable("jahr") String jahr){
        final List<Bon> list = bonService.getByJahr(jahr);
        return ResponseEntity.ok().body(list);

    }
}
