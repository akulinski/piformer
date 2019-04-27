package com.akulinski.piformer.core.services;

import com.akulinski.piformer.dto.BasicStats;
import com.akulinski.piformer.dto.Device;
import com.google.common.base.CharMatcher;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class BasicStatsService {

    private final CommandExecutorService commandExecutorService;

    public BasicStatsService(CommandExecutorService commandExecutorService) {
        this.commandExecutorService = commandExecutorService;
    }

    public BasicStats getBasicStats() {

        try {

            String rawOutput = commandExecutorService.executeCommand("sensors");
            return parseRawText(rawOutput);

        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        }

        return new BasicStats();
    }

    private BasicStats parseRawText(String raw) {
        BasicStats basicStats = new BasicStats();

        final String[] rawTextSplittedByDevices = raw.split("\n\n");

        List<Device> devices = parseDevicesAndGetTemps(rawTextSplittedByDevices);
        basicStats.setDeviceList(devices);

        return basicStats;
    }


    private List<Device> parseDevicesAndGetTemps(String[] rawTextSplittedByDevices) {

        List<Device> devices = new LinkedList<>();
        for (String rawDevice : rawTextSplittedByDevices) {

            Device device = new Device();

            final String[] deviceParameters = rawDevice.split("\n");

            for (String parameter : deviceParameters) {

                if (parameter.contains("°C")) {

                    String temperature = StringUtils.substringBetween(rawDevice, "+", "°C");
                    String devicePart = parameter.substring(0, parameter.indexOf(":"));
                    device.getTemperatures().put(devicePart, temperature);

                } else if (parameter.contains("RPM")) {

                    String fanSpeed = CharMatcher.digit().retainFrom(parameter);
                    String devicePart = parameter.substring(0, parameter.indexOf(":"));
                    device.getFanSpeeds().put(devicePart, fanSpeed);
                } else if (!parameter.contains(":")) {
                    device.setName(parameter);
                }
            }

            devices.add(device);
        }
        return devices;
    }

}
