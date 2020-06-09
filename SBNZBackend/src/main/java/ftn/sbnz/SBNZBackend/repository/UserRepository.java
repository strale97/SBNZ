package ftn.sbnz.SBNZBackend.repository;

import ftn.sbnz.SBNZBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    List<User> findAllByNameContainingOrLastNameContaining(String firstName, String lastName);
}
