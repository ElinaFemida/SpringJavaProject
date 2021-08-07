package ru.geekbrins.store.repositories.specifications;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrins.store.model.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);

}


