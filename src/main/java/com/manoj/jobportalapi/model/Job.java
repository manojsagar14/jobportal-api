package com.manoj.jobportalapi.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String salary;

    @Column(nullable = false)
    private String jobType; // FULL_TIME, PART_TIME, INTERNSHIP

    @Column(nullable = false)
    private String postedBy; // email of recruiter

    @Column(nullable = false)
    private LocalDateTime postedAt;

    @PrePersist
    public void prePersist() {
        postedAt = LocalDateTime.now();
    }

}