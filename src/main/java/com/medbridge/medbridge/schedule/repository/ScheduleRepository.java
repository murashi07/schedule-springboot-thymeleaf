package com.medbridge.medbridge.schedule.repository;

import com.medbridge.medbridge.schedule.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
}
