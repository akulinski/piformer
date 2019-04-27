package com.akulinski.piformer.dto;

import lombok.Data;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@Data
@ToString
public class BasicStats {
    private List<Device> deviceList;

    public BasicStats() {
        deviceList = new LinkedList<>();
    }
}
