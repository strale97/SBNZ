package ftn.sbnz.SBNZBackend.service;

import ftn.sbnz.SBNZBackend.model.HardDrive;
import ftn.sbnz.SBNZBackend.model.Konfiguracija;
import ftn.sbnz.SBNZBackend.model.Zahtevi;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Service
public class TestService {

    private KieContainer kieContainer;

    @Autowired
    public TestService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public void topPreporuke(ArrayList<Konfiguracija> konfiguracije, Zahtevi zahtevi) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("zahtevi", zahtevi);
        for (Konfiguracija konfiguracija: konfiguracije) {
            kieSession.insert(konfiguracija);
        }
        kieSession.fireAllRules();
        kieSession.dispose();
        ArrayList<Konfiguracija> top4 = new ArrayList<>();
        konfiguracije.sort(Comparator.comparing(Konfiguracija::getPoeni));
        for (int i = 0; i < 4; i++) {
            top4.add(konfiguracije.get(konfiguracije.size()-1-i));
        }
        for (Konfiguracija konfiguracija: top4) {
            System.out.println(konfiguracija.getIme() + ": " + konfiguracija.getPoeni());
            System.out.println("GPU: " + konfiguracija.getGpu().getIme());
            System.out.println("CPU: " + konfiguracija.getCpu().getIme());
            System.out.println("RAM: " + konfiguracija.getRam().getIme());
            System.out.println("Cena: " + konfiguracija.getCena());
            System.out.println("Laptop: " + konfiguracija.isLaptop());
            for (HardDrive h: konfiguracija.getHardDrives()) {
                System.out.println("Hard drive: " + h.getIme());
            }
            System.out.println("-------------------------------------------------------------");
        }
    }

}
