package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TimeSlotJpaRepository extends JpaRepository<TimeSlot, Long> {
    List<TimeSlot> findByTimeSlotDateAfter(Date date);
    List<TimeSlot> findByTimeSlotDateBefore(Date date);
    List<TimeSlot> findByTimeSlotDateBetween(Date startDate, Date endDate);
}
