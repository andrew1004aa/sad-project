package com.example.demo.Acitivity;

import jakarta.persistence.*;
import com.example.demo.Organizer.Organizer;
import java.util.Date;

@Entity
public class Activity {

    @Id
    @SequenceGenerator(
            name = "activity_sequence",
            sequenceName = "activity_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "activity_sequence"
    )
    private Integer activityId;

    private String name;

    private Date date;

    private String location;

    @ManyToOne
    @JoinColumn(name = "organizerId", referencedColumnName = "organizerId")
    private Organizer organizer;

    // Constructors
    public Activity() {
    }

    public Activity(String name, Date date, String location, Organizer organizer) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.organizer = organizer;
    }

    // Getters and Setters
    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // toString Method
    @Override
    public String toString() {
        return "Activity{" +
                "activityId=" + activityId +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", organizer=" + organizer +
                '}';
    }
}

