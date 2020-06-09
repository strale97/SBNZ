package ftn.sbnz.SBNZBackend.service;

import ftn.sbnz.SBNZBackend.model.*;
import ftn.sbnz.SBNZBackend.web.DTO.DrlDTO;
import org.apache.maven.shared.invoker.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;

@Service
public class TestService {

    @Autowired
    private KieContainer kieContainer;

    public Konfiguracija getById(int id){
        ArrayList<Konfiguracija> konfiguracije = testKonfiguracije();
        return konfiguracije.get(id);
    }

    public boolean dodajPravilo(String pravilo, String ime){
        String path = "..\\drools-spring-kjar\\src\\main\\resources\\sbnz\\integracija\\" + ime + ".drl";
        try {
            if(new File(path).exists()){
                return false;
            }
            PrintWriter out = new PrintWriter(new File(path));
            out.println(pravilo);
            out.close();
            cleanInstall();
            return true;
        } catch (MavenInvocationException | FileNotFoundException e){
            return false;
        } catch (RuntimeException e){
            new File(path).delete();
            return false;
        }
    }

    private void cleanInstall () throws RuntimeException, MavenInvocationException {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile( new File( "..\\drools-spring-kjar\\pom.xml" ) );
        ArrayList<String> goals = new ArrayList<String>();
        goals.add("clean");
        goals.add("install");
        request.setGoals(goals);
        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(System.getenv("M2_HOME")));
        invoker.execute( request );
    }

    public ArrayList<Konfiguracija> filter(String os, boolean laptop){
        ArrayList<Konfiguracija> konfs = new ArrayList<>();
        ArrayList<Konfiguracija> konfiguracije = testKonfiguracije();
        KieSession kieSession = kieContainer.newKieSession("konfig");
        kieSession.setGlobal("konfiguracije", konfs);
        kieSession.setGlobal("os", os);
        kieSession.setGlobal("laptop", laptop);
        kieSession.setGlobal("zahtevi", new Zahtevi());
        for (Konfiguracija konfiguracija: konfiguracije) {
            kieSession.insert(konfiguracija);
        }
        try {
            kieSession.fireAllRules();
        } catch (Exception e) {
            kieSession.dispose();
            return konfs;
        }
        konfs =  (ArrayList<Konfiguracija>) kieSession.getGlobal("konfiguracije");
        kieSession.dispose();
        return konfs;
    }

    public ArrayList<Konfiguracija> getAll(){
        return testKonfiguracije();
    }

    public ArrayList<Konfiguracija> topPreporuke(Zahtevi zahtevi) {
        ArrayList<Konfiguracija> konfiguracije = testKonfiguracije();
        KieSession kieSession = kieContainer.newKieSession("konfig");
        kieSession.setGlobal("konfiguracije", new ArrayList<>());
        kieSession.setGlobal("os", "");
        kieSession.setGlobal("laptop", false);
        kieSession.setGlobal("zahtevi", zahtevi);
        for (Konfiguracija konfiguracija: konfiguracije) {
            kieSession.insert(konfiguracija);
        }
        kieSession.fireAllRules();
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
            for (HardDrive h : konfiguracija.getHardDrives()) {
                System.out.println("Hard drive: " + h.getIme());
            }
            System.out.println("Cena: " + konfiguracija.getCena());
            System.out.println("Laptop: " + konfiguracija.isLaptop());
            System.out.println("-------------------------------------------------------------");
        }
        kieSession.dispose();
        return top4;
    }

    public void test(ArrayList<Konfiguracija> konfiguracije, Zahtevi zahtevi) {
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
            for (HardDrive h: konfiguracija.getHardDrives()) {
                System.out.println("Hard drive: " + h.getIme());
            }
            System.out.println("Cena: " + konfiguracija.getCena());
            System.out.println("Laptop: " + konfiguracija.isLaptop());
            System.out.println("-------------------------------------------------------------");
        }
    }

    private ArrayList<Konfiguracija> testKonfiguracije() {
        GPU gtx1050ti = new GPU();
        gtx1050ti.setIme("NVIDIA GTX 1050 Ti");
        gtx1050ti.setMemorija(4);
        gtx1050ti.setTipMemorije("GDDR5");

        GPU gtx1060 = new GPU();
        gtx1060.setIme("NVIDIA GTX 1060");
        gtx1060.setMemorija(6);
        gtx1060.setTipMemorije("GDDR5");

        GPU amdRx580 = new GPU();
        amdRx580.setIme("AMD Radeon RX 580");
        amdRx580.setMemorija(8);
        amdRx580.setTipMemorije("GDDR5");

        GPU integrisana = new GPU();
        integrisana.setIme("Integrated GPU");
        integrisana.setMemorija(2);
        integrisana.setTipMemorije("GDDR4");

        CPU ryzen32200g = new CPU();
        ryzen32200g.setIme("AMD Ryzen 3 2200G");
        ryzen32200g.setBrzina(3.2);
        ryzen32200g.setJezgra(4);
        ryzen32200g.setTredovi(8);

        CPU ryzen52600x = new CPU();
        ryzen52600x.setIme("AMD Ryzen 5 2600X");
        ryzen52600x.setBrzina(3.6);
        ryzen52600x.setJezgra(6);
        ryzen52600x.setTredovi(12);

        CPU i58400 = new CPU();
        i58400.setIme("Intel i5 8400");
        i58400.setBrzina(3.2);
        i58400.setJezgra(6);
        i58400.setTredovi(12);

        CPU celeron = new CPU();
        celeron.setIme("Intel Celeron J4005");
        celeron.setBrzina(2);
        celeron.setJezgra(2);
        celeron.setTredovi(2);

        RAM ram8gb = new RAM();
        ram8gb.setIme("8GB RAM memorije");
        ram8gb.setBrzina(2666);
        ram8gb.setMemorija(8);
        ram8gb.setTipMemorije("DDR4");

        RAM ram4gb = new RAM();
        ram4gb.setIme("4GB RAM memorije");
        ram4gb.setBrzina(2500);
        ram4gb.setMemorija(4);
        ram4gb.setTipMemorije("DDR3");

        RAM ram16gb = new RAM();
        ram16gb.setIme("16GB RAM memorije");
        ram16gb.setBrzina(3200);
        ram16gb.setMemorija(16);
        ram16gb.setTipMemorije("DDR4");

        RAM ram64gb = new RAM();
        ram64gb.setIme("64GB RAM memorije");
        ram64gb.setBrzina(4000);
        ram64gb.setMemorija(64);
        ram64gb.setTipMemorije("DDR4");

        HardDrive ssd250gb = new HardDrive();
        ssd250gb.setIme("SSD 250GB");
        ssd250gb.setTip("SSD");
        ssd250gb.setMemorija(250);

        HardDrive ssd500gb = new HardDrive();
        ssd500gb.setIme("SSD 500GB");
        ssd500gb.setTip("SSD");
        ssd500gb.setMemorija(500);

        HardDrive ssd1tb = new HardDrive();
        ssd1tb.setIme("SSD 1TB");
        ssd1tb.setTip("SSD");
        ssd1tb.setMemorija(1024);

        HardDrive hdd1tb = new HardDrive();
        hdd1tb.setIme("HDD 1TB");
        hdd1tb.setTip("HDD");
        hdd1tb.setMemorija(1024);

        HardDrive hdd500gb = new HardDrive();
        hdd500gb.setIme("HDD 500GB");
        hdd500gb.setTip("HDD");
        hdd500gb.setMemorija(500);

        HardDrive hdd2tb = new HardDrive();
        hdd2tb.setIme("HDD 2TB");
        hdd2tb.setTip("HDD");
        hdd2tb.setMemorija(2048);

        ArrayList<HardDrive> hardDrives = new ArrayList<>();
        hardDrives.add(ssd250gb);
        hardDrives.add(hdd1tb);

        Konfiguracija konfiguracija = new Konfiguracija();
        konfiguracija.setCpu(ryzen32200g);
        konfiguracija.setGpu(gtx1050ti);
        konfiguracija.setRam(ram8gb);
        konfiguracija.setHardDrives(hardDrives);
        konfiguracija.setId(1);
        konfiguracija.setIme("Moja konfiguracija");
        konfiguracija.setPoeni(0);
        konfiguracija.setCena(50000);
        konfiguracija.setOs("Windows");
        konfiguracija.setLaptop(false);

        ArrayList<HardDrive> hardDrives1 = new ArrayList<>();
        hardDrives1.add(hdd500gb);

        Konfiguracija konfiguracija1 = new Konfiguracija();
        konfiguracija1.setCpu(celeron);
        konfiguracija1.setGpu(integrisana);
        konfiguracija1.setRam(ram4gb);
        konfiguracija1.setHardDrives(hardDrives1);
        konfiguracija1.setId(2);
        konfiguracija1.setIme("Druga konfiguracija");
        konfiguracija1.setPoeni(0);
        konfiguracija1.setCena(29000);
        konfiguracija1.setOs("Windows");
        konfiguracija1.setLaptop(true);

        ArrayList<HardDrive> hardDrives2 = new ArrayList<>();
        hardDrives2.add(ssd500gb);
        hardDrives2.add(hdd2tb);

        Konfiguracija konfiguracija2 = new Konfiguracija();
        konfiguracija2.setCpu(ryzen52600x);
        konfiguracija2.setGpu(amdRx580);
        konfiguracija2.setRam(ram16gb);
        konfiguracija2.setHardDrives(hardDrives2);
        konfiguracija2.setId(3);
        konfiguracija2.setIme("Treca konfiguracija");
        konfiguracija2.setPoeni(0);
        konfiguracija2.setCena(70000);
        konfiguracija2.setOs("Windows");
        konfiguracija2.setLaptop(false);

        ArrayList<HardDrive> hardDrives3 = new ArrayList<>();
        hardDrives3.add(ssd500gb);
        hardDrives3.add(ssd1tb);

        Konfiguracija konfiguracija3 = new Konfiguracija();
        konfiguracija3.setCpu(i58400);
        konfiguracija3.setGpu(gtx1060);
        konfiguracija3.setRam(ram64gb);
        konfiguracija3.setHardDrives(hardDrives3);
        konfiguracija3.setId(4);
        konfiguracija3.setIme("Cetvrta konfiguracija");
        konfiguracija3.setPoeni(0);
        konfiguracija3.setCena(85000);
        konfiguracija3.setOs("NA");
        konfiguracija3.setLaptop(false);

        ArrayList<HardDrive> hardDrives4 = new ArrayList<>();
        hardDrives4.add(ssd500gb);

        Konfiguracija konfiguracija4 = new Konfiguracija();
        konfiguracija4.setCpu(i58400);
        konfiguracija4.setGpu(integrisana);
        konfiguracija4.setRam(ram8gb);
        konfiguracija4.setHardDrives(hardDrives4);
        konfiguracija4.setId(5);
        konfiguracija4.setIme("Peta konfiguracija");
        konfiguracija4.setPoeni(0);
        konfiguracija4.setCena(50000);
        konfiguracija4.setOs("NA");
        konfiguracija4.setLaptop(true);

        ArrayList<HardDrive> hardDrives5 = new ArrayList<>();
        hardDrives5.add(ssd250gb);
        hardDrives5.add(hdd500gb);

        Konfiguracija konfiguracija5 = new Konfiguracija();
        konfiguracija5.setCpu(ryzen32200g);
        konfiguracija5.setGpu(integrisana);
        konfiguracija5.setRam(ram8gb);
        konfiguracija5.setHardDrives(hardDrives5);
        konfiguracija5.setId(6);
        konfiguracija5.setIme("Sesta konfiguracija");
        konfiguracija5.setPoeni(0);
        konfiguracija5.setCena(38000);
        konfiguracija5.setOs("Linux");
        konfiguracija5.setLaptop(false);

        ArrayList<HardDrive> hardDrives6 = new ArrayList<>();
        hardDrives6.add(hdd1tb);

        Konfiguracija konfiguracija6 = new Konfiguracija();
        konfiguracija6.setCpu(celeron);
        konfiguracija6.setGpu(gtx1050ti);
        konfiguracija6.setRam(ram8gb);
        konfiguracija6.setHardDrives(hardDrives6);
        konfiguracija6.setId(7);
        konfiguracija6.setIme("Sedma konfiguracija");
        konfiguracija6.setPoeni(0);
        konfiguracija6.setCena(45000);
        konfiguracija6.setOs("Windows");
        konfiguracija6.setLaptop(true);

        ArrayList<HardDrive> hardDrives7 = new ArrayList<>();
        hardDrives7.add(hdd2tb);

        Konfiguracija konfiguracija7 = new Konfiguracija();
        konfiguracija7.setCpu(ryzen52600x);
        konfiguracija7.setGpu(gtx1050ti);
        konfiguracija7.setRam(ram8gb);
        konfiguracija7.setHardDrives(hardDrives7);
        konfiguracija7.setId(8);
        konfiguracija7.setIme("Osma konfiguracija");
        konfiguracija7.setPoeni(0);
        konfiguracija7.setCena(42000);
        konfiguracija7.setOs("Windows");
        konfiguracija7.setLaptop(false);

        ArrayList<Konfiguracija> konfiguracije = new ArrayList<>();
        konfiguracije.add(konfiguracija);
        konfiguracije.add(konfiguracija1);
        konfiguracije.add(konfiguracija2);
        konfiguracije.add(konfiguracija3);
        konfiguracije.add(konfiguracija4);
        konfiguracije.add(konfiguracija5);
        konfiguracije.add(konfiguracija6);
        konfiguracije.add(konfiguracija7);

        return konfiguracije;
    }

}
