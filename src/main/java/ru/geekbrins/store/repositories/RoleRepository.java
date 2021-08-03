package ru.geekbrins.store.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrins.store.model.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}