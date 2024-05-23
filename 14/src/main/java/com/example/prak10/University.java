package com.example.prak10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class University {
    private String name;
    private String creationDate; // Assuming creationDate is stored as a string for simplicity
}