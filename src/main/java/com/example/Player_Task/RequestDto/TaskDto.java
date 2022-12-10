package com.example.Player_Task.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private String taskName;
    private LocalDate fromDate;
    private LocalDate toDate;
}
