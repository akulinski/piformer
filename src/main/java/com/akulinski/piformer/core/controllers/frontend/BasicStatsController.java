package com.akulinski.piformer.core.controllers.frontend;

import com.akulinski.piformer.core.services.BasicStatsService;
import com.akulinski.piformer.dto.BasicStats;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicStatsController {

    private final BasicStatsService basicStatsService;

    public BasicStatsController(BasicStatsService basicStatsService) {
        this.basicStatsService = basicStatsService;
    }


    @GetMapping({"/", "index"})
    public String getIndex(Model model) {

        final BasicStats basicStats = basicStatsService.getBasicStats();
        model.addAttribute("devices", basicStats.getDeviceList());
        return "index";
    }

}
