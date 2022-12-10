package com.example.Player_Task.Repository;

import com.example.Player_Task.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    @Query("select t from Task t " +
            "where t.fromDate between :fromDateRange and :toDateRange " )
    List<Task> getAllTaskByDate( LocalDate fromDateRange,
                                  LocalDate toDateRange);
}
