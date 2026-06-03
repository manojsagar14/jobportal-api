package com.manoj.jobportalapi.repository;

import com.manoj.jobportalapi.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    // Find jobs by location
    List<Job> findByLocation(String location);

    // Find jobs by job type
    List<Job> findByJobType(String jobType);

    // Find jobs posted by a specific recruiter
    List<Job> findByPostedBy(String email);

    // Find jobs by title containing keyword
    List<Job> findByTitleContaining(String keyword);

}