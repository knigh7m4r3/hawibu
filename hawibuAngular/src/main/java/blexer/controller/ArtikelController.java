package blexer.controller;

import blexer.datalayer.model.Artikel;
import blexer.datalayer.service.ArtikelService;
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
public class ArtikelController {

    @Autowired
    private ArtikelService artikelService;

    //Get all coins
    @GetMapping("/api/artikel")
    public ResponseEntity<List<Artikel>> list() {
        final List<Artikel> list = artikelService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/api/artikel")
    public ResponseEntity<?> save(@RequestBody final Artikel artikel) {

        return ResponseEntity.ok().body(artikelService.saveEntity(artikel));
    }

    @GetMapping("/api/artikel/{id}")
    public ResponseEntity<Artikel> get(@PathVariable("id") final Integer id) {
        final Artikel artikel = artikelService.getEntity(id);
        return ResponseEntity.ok().body(artikel);
    }

    @PutMapping("/api/artikel/")
    public ResponseEntity<?> update(@RequestBody final Artikel artikel) {
        artikelService.updateEntity(artikel);
        return ResponseEntity.ok().body("Artikel successfully updated!");
    }

    @DeleteMapping("/api/artikel/{artikel}")
    public ResponseEntity<?> delete(@PathVariable("artikel") final Artikel artikel) {
        artikelService.deleteEntity(artikel);
        return ResponseEntity.ok().body("Artikel successfully deleted!");
    }
}
