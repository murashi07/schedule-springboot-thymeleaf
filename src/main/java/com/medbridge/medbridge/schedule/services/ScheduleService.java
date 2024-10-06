package com.medbridge.medbridge.schedule.services;

import com.medbridge.medbridge.schedule.model.Schedule;

import java.util.List;

public interface ScheduleService {
    void createSchedule(Schedule schedule);
    List<Schedule> findAllSchedule();

    Schedule getScheduleById(Long id);

    boolean updateSchedule(Schedule schedule, Long id);

    boolean deleteScheduleById(Long id);


}
