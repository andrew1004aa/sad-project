package com.example.demo.Organizer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping
@Controller
//@RequestMapping(path ="/organizer")
public class OrganizerController {
    private final OrganizerService organizerService;

    @Autowired
    public OrganizerController(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }

    @GetMapping("/findAll")
    public ModelAndView getOrganizer(){
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Organizer> organizers = organizerService.findAll();
        modelAndView.addObject("organizers", organizers);
        return modelAndView;
    }


}
