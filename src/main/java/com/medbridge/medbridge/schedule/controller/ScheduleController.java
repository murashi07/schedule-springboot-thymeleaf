//package com.medbridge.medbridge.schedule.controller;
//
//import com.medbridge.medbridge.schedule.model.Schedule;
//import com.medbridge.medbridge.schedule.repository.ScheduleRepository;
//import com.medbridge.medbridge.schedule.services.ScheduleService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/schedule")
//public class ScheduleController {
//    private ScheduleRepository scheduleRepository;
//    private ScheduleService scheduleService;
//
//    public ScheduleController(ScheduleRepository scheduleRepository, ScheduleService scheduleService) {
//        this.scheduleRepository = scheduleRepository;
//        this.scheduleService = scheduleService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Schedule>> getAllSchedule(){
//        return new ResponseEntity<>(scheduleService.findAllSchedule(), HttpStatus.OK);
//
//    }
//
//    @PostMapping
//    public ResponseEntity<String> createSchedule(@RequestBody Schedule schedule){
//        scheduleService.createSchedule(schedule);
//        return new ResponseEntity<>("schedule created successfully",HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateSchedule(@PathVariable Long id,
//                                                @RequestBody Schedule schedule){
//        scheduleService.updateSchedule(schedule,id);
//        return new ResponseEntity<>("schedule updated successfully", HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteSchedule(@PathVariable Long id){
//        boolean isDeleted= scheduleService.deleteScheduleById(id);
//        if(isDeleted){
//            return new ResponseEntity<>("Schedule deleted successfully",HttpStatus.OK);
//        }
//        return new ResponseEntity<>("Schedule not found",HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Schedule> getSchedule(@PathVariable Long id){
//        Schedule schedule=scheduleService.getScheduleById(id);
//        if (schedule!=null){
//            return ResponseEntity.ok(schedule);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//
//}
