package ftn.sbnz.SBNZBackend.service;


import ftn.sbnz.SBNZBackend.exceptions.PasswordsDoNotMatchException;
import ftn.sbnz.SBNZBackend.exceptions.UserAlreadyExistsException;
import ftn.sbnz.SBNZBackend.model.User;
import ftn.sbnz.SBNZBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email){
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
        } else{
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            if (user.isAdmin()) {
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            } else{
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            }
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    grantedAuthorities
            );
        }
    }

    public User createUser(User user){
        if (userRepository.findByEmail(user.getEmail()) != null) throw new UserAlreadyExistsException();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User changePassword(User user, String password1, String password2) {
        if (!password1.equals(password2)){
            throw new PasswordsDoNotMatchException("Password and confirmation password do not match");
        }
        user.setPassword(passwordEncoder.encode(password1));
        return userRepository.save(user);
    }

    public User updateProfile(User user, String newEmail, String newFirstName, String newLastName){
        if (userRepository.findByEmail(newEmail) != null && !user.getEmail().equals(newEmail)) throw new UserAlreadyExistsException();
        user.setEmail(newEmail);
        user.setName(newFirstName);
        user.setLastName(newLastName);
        return userRepository.save(user);
    }

}
