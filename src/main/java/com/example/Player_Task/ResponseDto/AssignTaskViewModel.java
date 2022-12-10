package com.example.Player_Task.ResponseDto;

import com.example.Player_Task.Entity.Player;
import com.example.Player_Task.Entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignTaskViewModel {
   private List<List<Task>> taskList;
   private List<List<Player>> playerList;
}
