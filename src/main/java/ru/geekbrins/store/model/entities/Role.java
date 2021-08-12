package ru.geekbrins.store.model.entities;

import lombok.Data;
<<<<<<< HEAD
import javax.persistence.*;

@Entity
@Data
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
=======

import javax.persistence.*;

@Entity
@Table(name = "role_table")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
>>>>>>> lesson_12
    private String name;
}
