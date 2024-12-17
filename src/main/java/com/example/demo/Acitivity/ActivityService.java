package com.example.demo.Acitivity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }
    public List<Activity> findAll(){
        return activityRepository.findAll();
    }
    public void save(Activity newactivity){activityRepository.save(newactivity);}
    public Optional<Activity> findById(Long id){return activityRepository.findById(id);}
}
