package com.app.university.repos;

import com.app.university.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleDAO extends JpaRepository<Schedule, Integer> {
    // Custom query methods can be added here if needed
    Schedule findByDayAndStartTime(String day, String startTime);
}
