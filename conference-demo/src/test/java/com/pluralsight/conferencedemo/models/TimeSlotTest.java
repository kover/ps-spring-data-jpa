package com.pluralsight.conferencedemo.models;

import com.pluralsight.conferencedemo.repositories.TimeSlotJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class TimeSlotTest {
    @Autowired
    private TimeSlotJpaRepository timeSlotJpaRepository;

    @Test
    public void testJpaTimeSlotAfter() throws Exception {
        List<TimeSlot> timeSlots = timeSlotJpaRepository.findByTimeSlotDateAfter(new Date());
        assertEquals(timeSlots.size(), 0);
    }

    @Test
    public void testJpaTimeSlotBefore() throws Exception {
        List<TimeSlot> timeSlots = timeSlotJpaRepository.findByTimeSlotDateBefore(new Date());
        assertTrue(timeSlots.size() > 0);
    }

    @Test
    public void testJpaTimeSlotBetween() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<TimeSlot> timeSlots = timeSlotJpaRepository
            .findByTimeSlotDateBetween(simpleDateFormat.parse("2020-01-01"), new Date());
        assertTrue(timeSlots.size() > 0);
    }
}
