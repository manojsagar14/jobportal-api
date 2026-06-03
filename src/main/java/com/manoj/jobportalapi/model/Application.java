package com.manoj.jobportalapi.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long jobId;

    @Column(nullable = false)
    private String applicantEmail;

    @Column(nullable = false)
    private String applicantName;

    @Column(nullable = false)
    private String status; // APPLIED, REVIEWED, ACCEPTED, REJECTED

    @Column(nullable = false)
    private LocalDateTime appliedAt;

    @PrePersist
    public void prePersist() {
        appliedAt = LocalDateTime.now();
        status = "APPLIED";
    }

}