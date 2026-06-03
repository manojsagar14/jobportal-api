package com.manoj.jobportalapi.service;

import com.manoj.jobportalapi.model.Job;
import com.manoj.jobportalapi.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    // Post a new job
    public Job postJob(Job job, String email) {
        job.setPostedBy(email);
        return jobRepository.save(job);
    }

    // Get all jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Get job by id
    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found!"));
    }

    // Search jobs by keyword
    public List<Job> searchJobs(String keyword) {
        return jobRepository.findByTitleContaining(keyword);
    }

    // Get jobs by location
    public List<Job> getJobsByLocation(String location) {
        return jobRepository.findByLocation(location);
    }

    // Delete job
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

}