package com.akulinski.piformer.core.services;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;

public abstract class AbstractExecutor {

    public String executeScriptAndReadOutput(File file) throws IOException {
        final ProcessBuilder processBuilder = new ProcessBuilder(file.getAbsolutePath());
        final Process start = processBuilder.start();
        final BufferedInputStream inputStream = new BufferedInputStream(start.getInputStream());
        return new String(inputStream.readAllBytes());
    }


    public String executeCommand(String command) throws IOException {
        final ProcessBuilder processBuilder = new ProcessBuilder(command);
        final Process start = processBuilder.start();
        final BufferedInputStream inputStream = new BufferedInputStream(start.getInputStream());
        return new String(inputStream.readAllBytes());
    }
}
