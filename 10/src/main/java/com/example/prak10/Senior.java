package com.example.prak10;

import org.springframework.stereotype.Component;

@Component
public class Senior implements Programmer{
    @Override
    public String doCoding() {
            return "Senior";
    }
}
