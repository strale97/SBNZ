package ftn.sbnz.SBNZBackend.web.controller;

import ftn.sbnz.SBNZBackend.model.Konfiguracija;
import ftn.sbnz.SBNZBackend.model.Zahtevi;
import ftn.sbnz.SBNZBackend.service.TestService;
import ftn.sbnz.SBNZBackend.web.DTO.DrlDTO;
import ftn.sbnz.SBNZBackend.web.DTO.FilterDTO;
import ftn.sbnz.SBNZBackend.web.DTO.ZahteviDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin("http://localhost:3000")
@RestController
public class ZahteviController {

    @Autowired
    private TestService testService;

    @PostMapping("/test")
    public ResponseEntity<ArrayList<Konfiguracija>> test(@RequestBody ZahteviDTO zahteviDTO){
        Zahtevi zahtevi = new Zahtevi(zahteviDTO);
        ArrayList<Konfiguracija> top4 = testService.topPreporuke(zahtevi);
        return new ResponseEntity<ArrayList<Konfiguracija>>(top4, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getById(@PathVariable("id") int id){
        Konfiguracija k = testService.getById(id);
        return new ResponseEntity<>("radi", HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<ArrayList<Konfiguracija>> getAll(){
        ArrayList<Konfiguracija> konfiguracije = testService.getAll();
        return new ResponseEntity<>(konfiguracije, HttpStatus.OK);
    }

    @PostMapping("/filter")
    public ResponseEntity<ArrayList<Konfiguracija>> filter(@RequestBody FilterDTO filterDTO){
        ArrayList<Konfiguracija> konfiguracije = testService.filter(filterDTO.getOs(), filterDTO.isLaptop());
        return new ResponseEntity<>(konfiguracije, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/dodajPravilo")
    public ResponseEntity<Boolean> dodajPravilo(@RequestBody DrlDTO drlDTO){
        boolean uspeo = testService.dodajPravilo(drlDTO.getText(), drlDTO.getIme());
        return new ResponseEntity<>(uspeo, HttpStatus.OK);
    }

    @PostMapping("/dodajKonfig")
    public ResponseEntity<Konfiguracija> dodajKonfiguraciju(@RequestBody Konfiguracija konfiguracija) {
        Konfiguracija k = testService.dodajKonfiguraciju(konfiguracija);
        return new ResponseEntity<>(k, HttpStatus.OK);
    }
}
