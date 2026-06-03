package com.manoj.jobportalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manoj.jobportalapi.model.Application;
import com.manoj.jobportalapi.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // Apply for a job
    @PostMapping("/{jobId}")
    public ResponseEntity<Application> applyForJob(@PathVariable Long jobId) {
        String email = SecurityContextHolder.getContext()
                .getAuthentication().getName();
        return ResponseEntity.ok(applicationService.applyForJob(jobId, email));
    }

    // Get my applications
    @GetMapping("/my")
    public ResponseEntity<List<Application>> getMyApplications() {
        String email = SecurityContextHolder.getContext()
                .getAuthentication().getName();
        return ResponseEntity.ok(applicationService.getMyApplications(email));
    }

    // Get all applications for a job
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<Application>> getJobApplications(@PathVariable Long jobId) {
        return ResponseEntity.ok(applicationService.getJobApplications(jobId));
    }

}