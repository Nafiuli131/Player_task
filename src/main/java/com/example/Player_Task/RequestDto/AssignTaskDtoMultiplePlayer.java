package com.example.Player_Task.RequestDto;

import com.example.Player_Task.Entity.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignTaskDtoMultiplePlayer {
     private List<Player> playerList;
     private Long taskId;
}
