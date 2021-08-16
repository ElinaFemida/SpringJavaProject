package ru.geekbrains.auth.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.auth.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}