package com.example.Player_Task.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerViewModel {
    private Long id;
    private String playerName;
}
