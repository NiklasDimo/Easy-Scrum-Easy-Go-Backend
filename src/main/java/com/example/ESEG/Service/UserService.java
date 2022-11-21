package com.example.ESEG.Service;

import com.example.ESEG.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.ESEG.model.User user = repo.findByUsername(username);
        if (user != null) {
            return new User(user.getUsername(), user.getPassword(), buildSimpleGrantedAuthorities(user.getRole()));
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    private static List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(final String roles) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(roles));
        return authorities;
    }

}
