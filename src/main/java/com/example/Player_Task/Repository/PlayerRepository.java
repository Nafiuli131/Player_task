package com.example.Player_Task.Repository;

import com.example.Player_Task.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {

}
