package com.akulinski.piformer.dto;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
@ToString
public class Device {
    private String name;
    private Map<String, String> temperatures;
    private Map<String, String> fanSpeeds;

    public Device(){
        temperatures = new HashMap<>();
        fanSpeeds = new HashMap<>();
    }
}
