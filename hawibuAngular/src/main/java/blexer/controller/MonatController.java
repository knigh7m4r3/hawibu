package blexer.controller;

import blexer.datalayer.model.Jahr;
import blexer.datalayer.model.Monat;
import blexer.datalayer.service.JahrService;
import blexer.datalayer.service.MonatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MonatController {

    @Autowired
    private MonatService monatService;

    @Autowired
    private JahrService jahrService;

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

    /**
     * Liefert Monat anhand des Namens zurück.
     * Falls kein Monat vorhanden wird, wird dieser erstellt.
     * Falls kein Jahr für den Monat vorhanden ist, wird auch das Jahr erstellt und zugeordnet.
     * @param monatName - Name des Monats im Format [Monat] [Jahreszahl, zweistellig]
     * @return Monat mit dem dazugehörigen Namen
     */
    @GetMapping("/api/monat/byName/{monatString}")
    public ResponseEntity<Monat> getByName(@PathVariable("monatString") String monatName){
        Monat monat = monatService.getByName(monatName);
        if(monat == null){
            monat = new Monat();
            monat.setName(monatName);
            final Integer jahrInt = Integer.parseInt(monatName.substring(monatName.length() - 2 ));
            Jahr jahr = this.jahrService.getByJahr(jahrInt + 2000);
            if(jahr == null){
                final Jahr jahrNew = new Jahr();
                jahrNew.setJahr(jahrInt + 2000);
                this.jahrService.saveEntity(jahrNew);
                jahr = this.jahrService.getByJahr(jahrInt + 2000);
            }
            monat.setJahr(jahr);
            final String monatShortName = monatName.replaceAll("[0-9]", "").trim();
            monat.setMonat(Monat.MONATZAHLMAPPINGAP.get(monatShortName));
            this.monatService.saveEntity(monat);
            monat = this.monatService.getByName(monatName);
        }
        return ResponseEntity.ok().body(monat);
    }

}
