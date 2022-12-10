package com.example.Player_Task.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDateDto {
    private LocalDate fromDateRange;
    private LocalDate toDateRange;
}
