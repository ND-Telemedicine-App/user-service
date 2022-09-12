package com.team4.user_service;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BusyTimeController {
    private final BusyTimeService busyTimeService;


    public BusyTimeController(BusyTimeService busyTimeService) {
        this.busyTimeService = busyTimeService;
    }

    @PostMapping(value = "/createBusyTime")
    public BusyTime createBusyTime(@RequestBody BusyTime busyTime){
        return busyTimeService.saveBusyTime(busyTime);
    }

    @GetMapping(value = "/busyTime/{id}")
    public List<BusyTime> getBusyTimeByDoctorId(@PathVariable Long id){
        return busyTimeService.findBusyTimesByDoctorId(id);
    }
}