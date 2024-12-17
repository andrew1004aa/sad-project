package com.example.demo.Registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

    @Query("SELECT r.activity.activityId FROM Registration r WHERE r.user.userId = :userId")
    List<Integer> findRegisteredActivityIdsByUserId(@Param("userId") Integer userId);

    List<Registration> findByUserUserId(Integer userId);
}

