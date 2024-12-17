package com.example.demo.Registration;

import com.example.demo.Acitivity.Activity;
import com.example.demo.Organizer.Organizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public void save(Registration registration) {
        registrationRepository.save(registration);
    }

    public List<Registration> findAll(){
        return registrationRepository.findAll();
    }

    public List<Integer> findRegisteredActivityIdsByUserId(Integer userId) {
//        System.out.println(registrationRepository.findRegisteredActivityIdsByUserId(userId));
        return registrationRepository.findRegisteredActivityIdsByUserId(userId);
    }


    public List<Activity> findRegisteredActivitiesByUserId(Integer userId) {
        // 查詢所有該使用者的報名紀錄，並提取活動資訊
        return registrationRepository.findByUserUserId(userId)
                .stream()
                .map(Registration::getActivity)
                .collect(Collectors.toList());
    }

}
