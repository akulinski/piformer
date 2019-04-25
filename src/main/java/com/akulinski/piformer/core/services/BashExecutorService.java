package com.akulinski.piformer.core.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Service
@Slf4j
public class BashExecutorService extends AbstractExecutor {


    public void runScript(String scriptName) throws IOException {

        File file = getFileFromResourcesWithName(scriptName);

        String output = executeScriptAndReadOutput(file);

        log.debug(String.format("%s|runScript|%s|%s", this.getClass().getName(), scriptName, output));
    }


    private File getFileFromResourcesWithName(String scriptName) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        final String script = String.format("scripts/%s.sh", scriptName);

        return new File(Objects.requireNonNull(classLoader.getResource(script)).getFile());
    }

}
