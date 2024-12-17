package com.example.demo.Organizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizerService {
    private final OrganizerRepository organizerRepository;

    @Autowired
    public OrganizerService(OrganizerRepository organizerRepository) {
        this.organizerRepository = organizerRepository;
    }

    public List<Organizer> findAll(){
        return organizerRepository.findAll();
    }

    public void save(Organizer newOrganizer){
        organizerRepository.save(newOrganizer);
    }

    public void deleteById(Integer OrganizerId){
        organizerRepository.deleteById(OrganizerId);
    }

    public Optional<Organizer> findById(Integer OrganizerId){
        return organizerRepository.findById(OrganizerId);
    }
}
