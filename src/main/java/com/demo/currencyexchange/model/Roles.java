package com.demo.currencyexchange.model;

import com.demo.currencyexchange.enam.RoleType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Roles {

        private Integer id;
        private RoleType name;

        public Roles() {}

        public Roles(RoleType name) {
            this.name = name;
        }
}
