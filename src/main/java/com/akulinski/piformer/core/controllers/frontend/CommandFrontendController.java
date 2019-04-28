package com.akulinski.piformer.core.controllers.frontend;

import com.akulinski.piformer.core.repository.CommandRepository;
import com.akulinski.piformer.core.services.CommandExecutorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommandFrontendController {

    private static final String COMMANDS_ATTRIBUTE = "commandsAttribute";
    private static final String COMMANDS = "commands";

    private final CommandExecutorService commandExecutorService;

    private final CommandRepository commandRepository;

    public CommandFrontendController(CommandExecutorService commandExecutorService, CommandRepository commandRepository) {
        this.commandExecutorService = commandExecutorService;
        this.commandRepository = commandRepository;
    }

    @GetMapping("/commands")
    public String showCommandsPage(Model model) {
        model.addAttribute(COMMANDS_ATTRIBUTE, commandRepository.findAll());
        return COMMANDS;
    }

}
