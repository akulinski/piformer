package com.akulinski.piformer.core.controllers;

import com.akulinski.piformer.core.domain.Command;
import com.akulinski.piformer.core.repository.CommandRepository;
import com.akulinski.piformer.core.services.BasicStatsService;
import com.akulinski.piformer.core.services.CommandExecutorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/api")
@Slf4j
public class CommandController {


    private final CommandExecutorService commandExecutorService;

    private final CommandRepository commandRepository;

    private final BasicStatsService basicStatsService;

    public CommandController(CommandRepository commandRepository, CommandExecutorService commandExecutorService, BasicStatsService basicStatsService) {
        this.commandRepository = commandRepository;
        this.commandExecutorService = commandExecutorService;
        this.basicStatsService = basicStatsService;
    }

    @GetMapping("/get-all-commands")
    public ResponseEntity getAllCommands() {
        log.debug(String.format("%s|getAllCommands", this.getClass().getName()));
        return ResponseEntity.ok(commandRepository.findAll());
    }


    @GetMapping("/execute-command/{id}")
    public ResponseEntity executeCommand(@PathVariable String id) throws IOException {
        Command command = commandRepository.findById(Long.parseLong(id)).orElseThrow(() -> new IllegalStateException(String.format("Command with id %s not found", id)));
        return ResponseEntity.ok(commandExecutorService.executeCommand(command.getValue()));
    }

    @GetMapping("/get-basic-stats")
    public ResponseEntity getBasicStats() {
        return ResponseEntity.ok(basicStatsService.getBasicStats());
    }

}
