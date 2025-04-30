package com.app.university.services;

import com.app.university.models.Schedule;
import com.app.university.repos.ScheduleDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ScheduleServiceTest {

    @Mock
    private ScheduleDAO scheduleDAO;

    @InjectMocks
    private ScheduleService scheduleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createSchedule_Success() {
        Schedule schedule = new Schedule();
        schedule.setDay("Monday");

        when(scheduleDAO.save(schedule)).thenReturn(schedule);

        Schedule createdSchedule = scheduleService.createSchedule(schedule);

        assertNotNull(createdSchedule);
        assertEquals("Monday", createdSchedule.getDay());
        verify(scheduleDAO, times(1)).save(schedule);
    }

    @Test
    void getScheduleById_Success() {
        Schedule schedule = new Schedule();
        schedule.setScheduleId(1);

        when(scheduleDAO.findById(1)).thenReturn(Optional.of(schedule));

        Schedule foundSchedule = scheduleService.getScheduleById(1);

        assertNotNull(foundSchedule);
        assertEquals(1, foundSchedule.getScheduleId());
        verify(scheduleDAO, times(1)).findById(1);
    }

    @Test
    void getScheduleById_NotFound_ThrowsException() {
        when(scheduleDAO.findById(1)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> scheduleService.getScheduleById(1));
        verify(scheduleDAO, times(1)).findById(1);
    }
}