package com.example.jobby.Service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jobby.DTO.LoginDTO;
import com.example.jobby.Entity.User;
import com.example.jobby.Exceptions.InvalidCredential;
import com.example.jobby.Exceptions.NotFoundException;
import com.example.jobby.Repository.UserRepo;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepo userRepo;

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList() 
        );
    }

    public User LoginUser(LoginDTO details) {
        User usr = userRepo.findByUsername(details.getUsername());
        if(usr == null){
            throw new NotFoundException("User Not Found");
        }

        if(!encoder.matches(details.getPassword(), usr.getPassword())){
            throw new InvalidCredential("Password Invalid");
        }

        return usr;
    }

    public User signUp(User details) {
        details.setPassword(encoder.encode(details.getPassword()));
        User usr = userRepo.save(details);
        return usr;
    }

    public User getUserById(Long userId) {
        Optional<User> usr = userRepo.findById(userId);
        if(!usr.isPresent()){
            throw new NotFoundException("User Not Found");
        }
        return usr.get();
    }
    
}
