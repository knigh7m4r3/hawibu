package blexer.controller;

import blexer.datalayer.model.Artikel;
import blexer.datalayer.service.ArtikelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtikelController {

    @Autowired
    private ArtikelService artikelService;

    //Get all coins
    @GetMapping("/api/artikel")
    public ResponseEntity<List<Artikel>> list(){
        List<Artikel> list = artikelService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/api/artikel")
    public ResponseEntity<?> save(@RequestBody Artikel artikel){
        artikelService.saveEntity(artikel);
        return ResponseEntity.ok().body("Artikel created!");
    }

    @GetMapping("/api/artikel/{id}")
    public ResponseEntity<Artikel> get(@PathVariable("id") Integer id){
        final Artikel artikel = artikelService.getEntity(id);
        return ResponseEntity.ok().body(artikel);
    }

    @PutMapping("/api/artikel/")
    public ResponseEntity<?> update(@RequestBody Artikel artikel){
        artikelService.updateEntity(artikel);
        return ResponseEntity.ok().body("Artikel successfully updated!");
    }

    @DeleteMapping("/api/artikel/{artikel}")
    public ResponseEntity<?> delete(@PathVariable("artikel") Artikel artikel){
        artikelService.deleteEntity(artikel);
        return ResponseEntity.ok().body("Artikel successfully deleted!");
    }
}
