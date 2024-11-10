package com.mandart.mandu.mandart.repository;

import com.mandart.mandu.mandart.domain.Goal;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public interface GoalRepository extends JpaRepository<Goal, Long> {
    Optional<List<Goal>> findByMandartId(long mandartId);
}
