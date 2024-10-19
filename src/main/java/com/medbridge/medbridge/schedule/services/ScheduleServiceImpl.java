package com.medbridge.medbridge.schedule.services;

import com.medbridge.medbridge.schedule.model.Schedule;
import com.medbridge.medbridge.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService{
    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public void createSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }


    @Override
    public List<Schedule> findAllSchedule() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule getScheduleById(Long id) {

        return scheduleRepository.findById(id).orElse(null);
    }



    @Override
    public boolean deleteScheduleById(Long id) {
        if (scheduleRepository.existsById(id)){
            scheduleRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateSchedule(Schedule schedule, Long id) {
        Optional<Schedule> scheduleOptional= scheduleRepository.findById(id);
        if (scheduleOptional.isPresent()){
            Schedule scheduleUpdate = scheduleOptional.get();
            scheduleUpdate.setPatientName(schedule.getPatientName());
            scheduleUpdate.setPhoneNumber(schedule.getPhoneNumber());
            scheduleUpdate.setReason(schedule.getReason());
            scheduleUpdate.setScheduleDate(schedule.getScheduleDate());
            scheduleUpdate.setScheduleTime(schedule.getScheduleTime());
            scheduleUpdate.setPatientLocation(schedule.getPatientLocation());

            scheduleRepository.save(scheduleUpdate);
            return true;
        }
        return false;
    }


}
