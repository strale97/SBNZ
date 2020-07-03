package ftn.sbnz.SBNZBackend.util;



import ftn.sbnz.SBNZBackend.model.Konfiguracija;

import java.util.Comparator;

public class Sorter implements Comparator<Konfiguracija> {

    @Override
    public int compare(Konfiguracija k1, Konfiguracija k2) {
        return k2.getSkor().getSuma() - k1.getSkor().getSuma();
    }
}
