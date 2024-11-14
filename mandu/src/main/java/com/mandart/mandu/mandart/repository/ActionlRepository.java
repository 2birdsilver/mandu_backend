package com.mandart.mandu.mandart.repository;

import com.mandart.mandu.mandart.domain.Action;
import com.mandart.mandu.mandart.domain.Goal;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public interface ActionlRepository extends JpaRepository<Action, Long> {
    Optional<List<Action>> findActionsByGoalId(long goalId);
}
