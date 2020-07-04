package ftn.sbnz.SBNZBackend.repository;

import ftn.sbnz.SBNZBackend.model.Konfiguracija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KonfiguracijaRepository extends JpaRepository<Konfiguracija, Integer> {
    Konfiguracija findById(int id);
}
