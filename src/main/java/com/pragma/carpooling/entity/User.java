package com.pragma.carpooling.entity;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private String lastName;
    private String phoneNumber;
    private String address;
    @Id
    private String email;
    private String password;

}
