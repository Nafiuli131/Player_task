package com.example.Player_Task.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;
    @Column(name = "task_name")
    private String taskName;
    @Column(name = "from_date")
    private LocalDate fromDate;
    @Column(name = "to_date")
    private LocalDate toDate;
@ManyToMany(fetch = FetchType.LAZY,
        cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
        })
@JoinTable(name = "player_task",
        joinColumns = { @JoinColumn(name = "task_id") },
        inverseJoinColumns = { @JoinColumn(name = "player_id") })
    @JsonIgnore
    private List<Player> players = new ArrayList<>();
}
