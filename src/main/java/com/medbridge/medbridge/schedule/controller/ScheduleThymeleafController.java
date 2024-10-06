package com.medbridge.medbridge.schedule.controller;

import com.medbridge.medbridge.schedule.model.Schedule;
import com.medbridge.medbridge.schedule.services.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/thymeleaf/schedule")
public class ScheduleThymeleafController {

    private final ScheduleService scheduleService;

    public ScheduleThymeleafController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        return "index";
    }

    // List all schedules
    @GetMapping
    public String getAllSchedules(Model model) {
        List<Schedule> schedules = scheduleService.findAllSchedule();
        model.addAttribute("schedules", schedules);
        return "schedule-list";
    }

    // Show create form
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("schedule", new Schedule());
        return "schedule-form";
    }

    // Save new schedule
    @PostMapping
    public String createSchedule(@ModelAttribute Schedule schedule) {
        scheduleService.createSchedule(schedule);
        return "redirect:/thymeleaf/schedule";
    }

    // Show update form
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Schedule schedule = scheduleService.getScheduleById(id);
        model.addAttribute("schedule", schedule);
        return "schedule-form";
    }

    // Update existing schedule
    @PostMapping("/{id}")
    public String updateSchedule(@PathVariable Long id, @ModelAttribute Schedule schedule) {
        scheduleService.updateSchedule(schedule, id);
        return "redirect:/thymeleaf/schedule";
    }

    // Delete schedule
    @GetMapping("/delete/{id}")
    public String deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteScheduleById(id);
        return "redirect:/thymeleaf/schedule";
    }
}
