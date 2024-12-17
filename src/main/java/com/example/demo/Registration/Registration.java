package com.example.demo.Registration;


import com.example.demo.Acitivity.Activity;
import com.example.demo.User.User;
import jakarta.persistence.*;

@Entity
public class Registration {


    @Id
    @SequenceGenerator(
            name = "registration_sequence",
            sequenceName = "registration_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "registration_sequence"
    )
    private Integer registrationId;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "activityId", referencedColumnName = "activityId", nullable = false)
    private Activity activity;

    private String status;

    private String studentId;

    private String email;

    private String pname;

    // Constructors
    public Registration() {
    }

    public Registration(User user, Activity activity, String status, String studentId, String email, String pname) {
        this.user = user;
        this.activity = activity;
        this.status = status;
        this.studentId = studentId;
        this.email = email;
        this.pname = pname;
    }

    // Getters and Setters
    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }

    // toString Method
    @Override
    public String toString() {
        return "Registration{" +
                "registrationId=" + registrationId +
                ", user=" + user +
                ", activity=" + activity +
                ", status='" + status + '\'' +
                '}';
    }


}
