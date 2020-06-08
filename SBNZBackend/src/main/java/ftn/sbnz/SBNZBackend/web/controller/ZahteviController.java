package ftn.sbnz.SBNZBackend.web.controller;

import ftn.sbnz.SBNZBackend.model.Konfiguracija;
import ftn.sbnz.SBNZBackend.model.Zahtevi;
import ftn.sbnz.SBNZBackend.service.TestService;
import ftn.sbnz.SBNZBackend.web.DTO.ZahteviDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin("http://localhost:3000")
@RestController
public class ZahteviController {

    @Autowired
    private TestService testService;

    @PostMapping("/test")
    public ResponseEntity<String> test(@RequestBody ZahteviDTO zahteviDTO){
        Zahtevi zahtevi = new Zahtevi(zahteviDTO);
        ArrayList<Konfiguracija> top4 = testService.topPreporuke(zahtevi);
        return new ResponseEntity<String>("radi", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getById(@PathVariable("id") int id){
        Konfiguracija k = testService.getById(id);
        return new ResponseEntity<>("radi", HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<String> getAll(){
        ArrayList<Konfiguracija> konfiguracije = testService.getAll();
        return new ResponseEntity<>("radi", HttpStatus.OK);
    }
}
