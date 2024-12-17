package com.example.demo.Registration;


import com.example.demo.Acitivity.Activity;
import com.example.demo.Acitivity.ActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RequestMapping
@Controller
public class RegistrationController {

    private final RegistrationService registrationService;
    private final ActivityService activityService;

    public RegistrationController(RegistrationService registrationService, ActivityService activityService) {
        this.registrationService = registrationService;
        this.activityService = activityService;
    }

    @GetMapping("/registrationHome")
    public ModelAndView registrationHome() {
        ModelAndView modelAndView = new ModelAndView("activitysheet");
        return modelAndView;
    }

    @PostMapping("/toregistrate")
    public ModelAndView registrate(@RequestParam("activityId") Long activityId) {
        ModelAndView modelAndView = new ModelAndView("registrate");
        Optional<Activity> activity = activityService.findById(activityId);
        Activity activity_info = activity.orElse(null);
        modelAndView.addObject("activity_info", activity_info);
        return modelAndView;
    }

    @PostMapping("/registrate")
    public ModelAndView registrate(Registration registration) {
        registrationService.save(registration);

        ModelAndView modelAndView = new ModelAndView("activitysheet"); // find html file

        Iterable<Activity> activities = activityService.findAll(); // get activities
        modelAndView.addObject("activities", activities); // add adtivities into html file

        // Simulate logged-in user ID (replace with actual user authentication)
        Integer loggedInUserId = 1000;

        // Retrieve the activity IDs for which the user is already registered
        List<Integer> registeredActivityIds = registrationService.findRegisteredActivityIdsByUserId(loggedInUserId);
        modelAndView.addObject("registeredActivityIds", registeredActivityIds);

        // Add success message to the model
        modelAndView.addObject("successMessage", "報名成功！");

        return modelAndView;
    }


}
