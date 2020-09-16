package com.demo.currencyexchange.repository.entity;

import com.demo.currencyexchange.enam.RoleType;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class RolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RoleType name;

    public RolesEntity() {}

    public RolesEntity(RoleType name) {
        this.name = name;
    }

}
