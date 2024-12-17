package com.example.demo.Organizer;

import jakarta.persistence.*;

@Entity
public class Organizer {

    @Id
    @SequenceGenerator(
            name = "organizer_sequence",
            sequenceName = "organizer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "organizer_sequence"
    )
    private Integer organizerId;

    private String name;

    private String contactInfo;

    // Constructors
    public Organizer() {
    }

    public Organizer(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    // Getters and Setters
    public Integer getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Integer organizerId) {
        this.organizerId = organizerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    // toString Method
    @Override
    public String toString() {
        return "Organizer{" +
                "organizerId=" + organizerId +
                ", name='" + name + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }
}