package com.conferenceSystem.controller;

import com.conferenceSystem.model.Conference;
import com.conferenceSystem.service.ConferenceService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConferenceController {
    private ConferenceService conferenceService;
    private ConferenceController(ConferenceService conferenceService){
        this.conferenceService = conferenceService;
    }
    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Conference> listConference= conferenceService.listAll();
        model.addAttribute("listConference", listConference);
        return "index";
    }

}
