package ru.geekbrins.store.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrins.store.model.entities.User;
import ru.geekbrins.store.services.UserService;

import java.security.Principal;
import java.util.Optional;

@RestController
@Profile("dao")
@Slf4j
@RequiredArgsConstructor
public class DaoController {

    private final UserService userService;

    @GetMapping("/dao")
    public String daoTestPage(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to find user by username: " + principal.getName()));
        return "authenticated: " + user.getUsername() + " : " + user.getEmail();
    }

    @GetMapping()
    public Page<User> usersPage(){
        return (Page<User>) userService.findAll();
    }

    @GetMapping("/score/get/{id}")
    public int getUserScore(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        return user.get().getScore();
    }

        @GetMapping("/score/get/current")
    public int getCurrentUserScore(Principal principal){
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        return user.getScore();
    }

    @GetMapping("/score/inc")
    public int incrementScore(Principal principal){
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        user.setScore(user.getScore() + 1);
        return user.getScore();
    }

    @GetMapping("/score/dec")
    public int decrementScore(Principal principal){
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        user.setScore(user.getScore() - 1);
        return user.getScore();
    }
}