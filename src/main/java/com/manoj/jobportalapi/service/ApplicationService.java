package com.manoj.jobportalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manoj.jobportalapi.model.Application;
import com.manoj.jobportalapi.model.User;
import com.manoj.jobportalapi.repository.ApplicationRepository;
import com.manoj.jobportalapi.repository.UserRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserRepository userRepository;

    // Apply for a job
    public Application applyForJob(Long jobId, String email) {

        // Check if already applied
        if (applicationRepository.existsByJobIdAndApplicantEmail(jobId, email)) {
            throw new RuntimeException("You have already applied for this job!");
        }

        // Get user details
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        // Create application
        Application application = new Application();
        application.setJobId(jobId);
        application.setApplicantEmail(email);
        application.setApplicantName(user.getName());

        return applicationRepository.save(application);
    }

    // Get my applications
    public List<Application> getMyApplications(String email) {
        return applicationRepository.findByApplicantEmail(email);
    }

    // Get all applications for a job
    public List<Application> getJobApplications(Long jobId) {
        return applicationRepository.findByJobId(jobId);
    }

}