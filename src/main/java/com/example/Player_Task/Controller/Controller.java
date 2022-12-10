package com.example.Player_Task.Controller;

import com.example.Player_Task.Entity.Player;
import com.example.Player_Task.Entity.Task;
import com.example.Player_Task.RequestDto.AssignTaskDtoMultiplePlayer;
import com.example.Player_Task.RequestDto.PlayerDto;
import com.example.Player_Task.RequestDto.ScheduleDateDto;
import com.example.Player_Task.RequestDto.TaskDto;
import com.example.Player_Task.ResponseDto.AssignTaskViewModel;
import com.example.Player_Task.Service.Service;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
public class Controller {

    @Autowired
    Service service;
    @Autowired
    private ModelMapper modelMapper;


    @PostMapping("/create_player")
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerDto playerDto){
        Player playerRequest = modelMapper.map( playerDto,Player.class);
        Player playerCreation = service.createPlayer(playerRequest).getBody();
        PlayerDto playerResponse = modelMapper.map(playerCreation, PlayerDto.class);
        return new ResponseEntity<PlayerDto>(playerResponse, HttpStatus.CREATED);
    }

    @PostMapping("/create_task")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto){
        Task taskRequest = modelMapper.map( taskDto,Task.class);
        Task taskCreation = service.createTask(taskRequest).getBody();
        TaskDto taskResponse = modelMapper.map(taskCreation, TaskDto.class);
        return new ResponseEntity<TaskDto>(taskResponse, HttpStatus.CREATED);
    }

    @PostMapping("/assign_task")
    public ResponseEntity<Task>
    createAssignTask(@RequestBody AssignTaskDtoMultiplePlayer assignTaskDtoMultiplePlayer){
        return new ResponseEntity<Task>
                (service.createAssignTask(assignTaskDtoMultiplePlayer),HttpStatus.OK);
    }

    @GetMapping("/player_info/{playerId}")
    public Optional<Player> getPlayerInfo(@PathVariable Long playerId){
        return service.getInfo(playerId);
    }

    @GetMapping("/task_info/{taskId}")
    public Optional<Task> getTaskInfo(@PathVariable Long taskId){
        return service.getTaskInfo(taskId);
    }

    @GetMapping("/assign_task_between_date")
    public List<Task> assignTaskViewModelList(@RequestBody ScheduleDateDto scheduleDateDto){
        LocalDate fromDateRange = scheduleDateDto.getFromDateRange();
        LocalDate toDateRange = scheduleDateDto.getToDateRange();
        List<Task> tasks = service.assignTaskViewModelList(fromDateRange,toDateRange);
        return tasks;
    }
}
