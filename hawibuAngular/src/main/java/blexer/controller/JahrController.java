package blexer.controller;

import blexer.datalayer.service.JahrService;
import blexer.datalayer.model.Jahr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JahrController {

    @Autowired
    private JahrService jahrService;

    //Get all coins
    @GetMapping("/api/jahr")
    public ResponseEntity<List<Jahr>> list(){
        List<Jahr> list = jahrService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/api/jahr")
    public ResponseEntity<?> save(@RequestBody Jahr jahr){
        jahrService.saveEntity(jahr);
        return ResponseEntity.ok().body("Jahr created!");
    }

    @GetMapping("/api/jahr/{id}")
    public ResponseEntity<Jahr> get(@PathVariable("id") Integer id){
        final Jahr jahr = jahrService.getEntity(id);
        return ResponseEntity.ok().body(jahr);
    }

    @PutMapping("/api/jahr/")
    public ResponseEntity<?> update(@RequestBody Jahr jahr){
        jahrService.updateEntity(jahr);
        return ResponseEntity.ok().body("Jahr successfully updated!");
    }

    @DeleteMapping("/api/jahr/{jahr}")
    public ResponseEntity<?> delete(@PathVariable("jahr") Jahr jahr){
        jahrService.deleteEntity(jahr);
        return ResponseEntity.ok().body("Jahr successfully deleted!");
    }
}
