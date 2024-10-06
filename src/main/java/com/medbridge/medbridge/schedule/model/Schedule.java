package com.medbridge.medbridge.schedule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    private String patientName;
    private String phoneNumber;
    private String reason;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date scheduleDate;
    private String scheduleTime;
    private String patientLocation;

}
