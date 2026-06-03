package com.manoj.jobportalapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manoj.jobportalapi.model.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    // Get all applications for a specific job
    List<Application> findByJobId(Long jobId);

    // Get all applications by a specific user
    List<Application> findByApplicantEmail(String email);

    // Check if user already applied for a job
    boolean existsByJobIdAndApplicantEmail(Long jobId, String email);

}