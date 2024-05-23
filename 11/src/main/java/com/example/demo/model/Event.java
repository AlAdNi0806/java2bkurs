//package com.example.demo.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.Data;
//
//@Data
//@Entity
//@Table(name = "Event")
//public class Event {
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    private String title;
//    private String description;
//    private String location;
//    private int maxPeople;
//    private String status;
//}
//
//
//
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private String location;
    private String date;
    private int maxPeople;
    private String status;

    private Long ownerId;
}
