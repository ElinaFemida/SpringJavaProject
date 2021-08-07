package ru.geekbrins.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrins.store.model.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);

}
