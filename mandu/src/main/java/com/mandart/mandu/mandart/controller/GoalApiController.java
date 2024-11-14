package com.mandart.mandu.mandart.controller;

import com.mandart.mandu.mandart.domain.Goal;
import com.mandart.mandu.mandart.dto.GoalResponse;
import com.mandart.mandu.mandart.service.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class GoalApiController {

    private final GoalService goalService;

    @GetMapping("/api/goals")
    public ResponseEntity<List<GoalResponse>> findAllGoals() {
        List<GoalResponse> goals = goalService.findAll()
                .stream()
                .map(GoalResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(goals);
    }

    @GetMapping("/api/goal/{id}")
    public ResponseEntity<GoalResponse> findGoalById(@PathVariable long id) {
        Goal goal = goalService.findById(id);

        return ResponseEntity.ok()
                .body(new GoalResponse(goal));
    }

    @GetMapping("/api/goals/{mandartId}")
    public ResponseEntity<List<GoalResponse>> findGoalsByMandartId(@PathVariable long mandartId) {
        List<GoalResponse> goals = goalService.findByMandartId(mandartId)
                .orElse(Collections.emptyList())
                .stream()
                .map(GoalResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(goals);
    }
}
