package com.conferenceSystem.controller;

import com.conferenceSystem.model.Conference;
import com.conferenceSystem.service.ConferenceService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ConferenceController {
    private ConferenceService conferenceService;

    private ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }
    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Conference> listConference= conferenceService.listAll();
        model.addAttribute("listConference",listConference);
        return "index";
    }
    @RequestMapping("/new")
    public String showNewConferenceForm(Model model){
        Conference conference = new Conference();
        model.addAttribute("conference",conference);
        return "new_conference";

    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveConference(@ModelAttribute("conference") Conference conference){
        conferenceService.save(conference);
        return "redirect:/";

    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditConferenceForm(@PathVariable (name ="id" ) Long id){
        ModelAndView  modelAndView = new ModelAndView("edit_Conference");
        Conference conference = conferenceService.get(id);
        modelAndView.addObject("conference",conference);
        return modelAndView;

    }
    @RequestMapping("/delete/{id}")
    public String deleteConference(@PathVariable (name ="id" ) Long id){
        conferenceService.delete(id);
        return "redirect:/";
    }
}
