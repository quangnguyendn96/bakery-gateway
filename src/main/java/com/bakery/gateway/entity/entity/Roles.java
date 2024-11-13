package com.bakery.gateway.entity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles {
    @Column(name = "rolesid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolesId;
}
