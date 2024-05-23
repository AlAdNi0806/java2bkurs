package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.Set;

//
//import java.sql.Array;
//
//@Data
//@Entity
//@Table(name = "Users")
//public class Users {
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    private String fullName;
//    private String username;
//    private String password;
//
//    private String[] events;
//
//    private String role;
//}
//
//
//
//
@Data
@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue
    private Long id;

    private String fullName;
    private String username;
    private String password;


    private String role;
}
