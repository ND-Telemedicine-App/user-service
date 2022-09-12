package com.team4.user_service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusyTimeRepository extends JpaRepository<BusyTime, Long> {
   List<BusyTime> findBusyTimeByDoctorId(Long id);
}
