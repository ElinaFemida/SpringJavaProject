package ru.geekbrins.store.services;

<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrins.store.model.entities.Role;
import ru.geekbrins.store.model.entities.User;
import ru.geekbrins.store.repositories.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Profile("dao")
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", username)));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
=======

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.geekbrins.store.model.entities.Role;
import ru.geekbrins.store.model.entities.User;
import ru.geekbrins.store.repositories.UserRepository;
import ru.geekbrins.store.repositories.specifications.RoleRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        Role role = roleRepository.findByName("ROLE_USER");
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User findByLoginAndPassword(String login, String password) {
        User userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
>>>>>>> lesson_12
    }
}
