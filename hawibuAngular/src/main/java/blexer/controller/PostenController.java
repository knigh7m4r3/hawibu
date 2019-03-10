package blexer.controller;

import blexer.datalayer.model.Posten;
import blexer.datalayer.service.PostenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostenController {

    @Autowired
    private PostenService postenService;

    //Get all coins
    @GetMapping("/api/posten")
    public ResponseEntity<List<Posten>> list(){
        List<Posten> list = postenService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/api/posten")
    public ResponseEntity<?> save(@RequestBody Posten posten){
        postenService.saveEntity(posten);
        return ResponseEntity.ok().body("Posten created!");
    }

    @GetMapping("/api/posten/{id}")
    public ResponseEntity<Posten> get(@PathVariable("id") Integer id){
        final Posten posten = postenService.getEntity(id);
        return ResponseEntity.ok().body(posten);
    }

    @PutMapping("/api/posten/")
    public ResponseEntity<?> update(@RequestBody Posten posten){
        postenService.updateEntity(posten);
        return ResponseEntity.ok().body("Posten successfully updated!");
    }

    @DeleteMapping("/api/posten/{posten}")
    public ResponseEntity<?> delete(@PathVariable("posten") Posten posten){
        postenService.deleteEntity(posten);
        return ResponseEntity.ok().body("Posten successfully deleted!");
    }
}
