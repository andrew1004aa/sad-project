package com.example.demo.Acitivity;


import com.example.demo.Registration.Registration;
import com.example.demo.Registration.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping
@Controller
public class ActicityContorller {
    private final ActivityService activityService;
    private final RegistrationService registrationService;

    @Autowired
    public ActicityContorller(ActivityService activityService, RegistrationService registrationService) {
        this.activityService = activityService;
        this.registrationService = registrationService;
    }

    @GetMapping("/findAllActivity")
    public ModelAndView findAllActivity() {
        ModelAndView modelAndView = new ModelAndView("activitysheet"); // find html file

        Iterable<Activity> activities = activityService.findAll(); // get activities
        modelAndView.addObject("activities", activities); // add adtivities into html file

        // Simulate logged-in user ID (replace with actual user authentication)
        Integer loggedInUserId = 1000;

        // Retrieve the activity IDs for which the user is already registered
        List<Integer> registeredActivityIds = registrationService.findRegisteredActivityIdsByUserId(loggedInUserId);
        modelAndView.addObject("registeredActivityIds", registeredActivityIds);

        return modelAndView;
    }

    @GetMapping("/myActivity")
    public ModelAndView myActivity() {
        ModelAndView modelAndView = new ModelAndView("myActivity");
        Integer loggedInUserId = 1000;
        // 從 registrationService 查詢使用者已報名的活動
        List<Activity> registeredActivities = registrationService.findRegisteredActivitiesByUserId(loggedInUserId);
        // 將已報名的活動清單加入 Model
        modelAndView.addObject("registeredActivities", registeredActivities);

        return modelAndView;
    }



}
