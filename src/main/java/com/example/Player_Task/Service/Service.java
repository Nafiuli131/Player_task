package com.example.Player_Task.Service;

import com.example.Player_Task.Entity.Player;
import com.example.Player_Task.Entity.Task;
import com.example.Player_Task.Repository.PlayerRepository;
import com.example.Player_Task.Repository.TaskRepository;
import com.example.Player_Task.RequestDto.AssignTaskDtoMultiplePlayer;
import com.example.Player_Task.RequestDto.PlayerIdDto;
import com.example.Player_Task.ResponseDto.AssignTaskViewModel;
import com.example.Player_Task.ResponseDto.PlayerViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    PlayerViewModel playerViewModel;
    private final PlayerRepository playerRepository;

    private final TaskRepository taskRepository;

    private String Message = "player_created_successfully";



    public Service(PlayerRepository playerRepository, TaskRepository taskRepository) {
        this.playerRepository = playerRepository;
        this.taskRepository = taskRepository;
    }


    public ResponseEntity<Player> createPlayer(Player player){
        return new ResponseEntity<Player>( playerRepository.save(player), HttpStatus.CREATED);
    }

    public ResponseEntity<Task> createTask(Task task) {
        return new ResponseEntity<Task>( taskRepository.save(task), HttpStatus.CREATED);
    }

    public Task createAssignTask(AssignTaskDtoMultiplePlayer assignTaskDto) {
        Task task = taskRepository.findById(assignTaskDto.getTaskId()).get();
        task.setId(task.getId());
        task.setTaskName(task.getTaskName());
        task.setFromDate(task.getFromDate());
        task.setToDate(task.getToDate());
        task.setPlayers(assignTaskDto.getPlayerList());
        taskRepository.save(task);
        return task;
    }

    public Optional<Player> getInfo(Long id) {
        return playerRepository.findById(id);
    }

    public Optional<Task> getTaskInfo(Long taskId) {
        return taskRepository.findById(taskId);
    }

    public List<Task> assignTaskViewModelList (LocalDate range1, LocalDate range2){
        List<Task> taskList = taskRepository.getAllTaskByDate(range1,range2);
        return taskList;
    }
}
