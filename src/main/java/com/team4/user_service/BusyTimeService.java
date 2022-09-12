package com.team4.user_service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusyTimeService {
    private final BusyTimeRepository busyTimeRepository;

    public BusyTimeService(BusyTimeRepository busyTimeRepository, UserRepository userRepository) {
        this.busyTimeRepository = busyTimeRepository;
    }

    public BusyTime saveBusyTime(BusyTime busyTime){
        return busyTimeRepository.save(busyTime);
    }

    public List<BusyTime> findBusyTimesByDoctorId(Long id){
        return busyTimeRepository.findBusyTimeByDoctorId(id);
    }
}