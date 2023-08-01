package com.ingym.DailyTracking.todo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepositary extends JpaRepository<Todo,Integer>{
        public List<Todo> findByUsername(String username);
}
