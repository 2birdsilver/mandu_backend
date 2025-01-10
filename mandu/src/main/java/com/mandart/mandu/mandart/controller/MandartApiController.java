package com.mandart.mandu.mandart.controller;

import com.mandart.mandu.mandart.domain.Action;
import com.mandart.mandu.mandart.domain.Goal;
import com.mandart.mandu.mandart.dto.GoalResponse;
import com.mandart.mandu.mandart.dto.MandartResponse;
import com.mandart.mandu.mandart.domain.Mandart;
import com.mandart.mandu.mandart.service.ActionService;
import com.mandart.mandu.mandart.service.GoalService;
import com.mandart.mandu.mandart.service.MandartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MandartApiController {

    private final MandartService mandartService;
    private final GoalService goalService;
    private final ActionService actionService;

    @GetMapping("/mandarts")
    public ResponseEntity<List<MandartResponse>> findAllMandarts() {
        List<MandartResponse> mandarts = mandartService.findAll()
                .stream()
                .map(MandartResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(mandarts);
    }

    @GetMapping("/mandart/{id}")
    public ResponseEntity<MandartResponse> findMandartById(@PathVariable long id) {
        Mandart mandart = mandartService.findById(id);
        MandartResponse mandartResponse = new MandartResponse(mandart);

        /*만다라트에 따른 목표 리스트 조회*/
        List<Goal> goals = goalService.findByMandartId(mandart.getId())
                .orElse(Collections.emptyList())
                .stream()
                .toList();

        // 목표에 따른 action 리스트 조회
        List<GoalResponse> goalResponses = goals
                .stream()
                .map(goal -> {
                    GoalResponse goalResponse = new GoalResponse(goal);  // Goal 객체를 GoalResponse 객체로 변환

                    List<Action> actions = actionService.findActionsByGoalId(goal.getId())
                            .orElse(Collections.emptyList());  // 목표에 따른 action 리스트 조회

                    goalResponse.setActionList(actions);  // GoalResponse에 action 리스트 설정

                    return goalResponse;  // 변형된 GoalResponse 객체를 리턴
                })
                .toList();

        mandartResponse.setGoalList(goalResponses);

        return ResponseEntity.ok()
                .body(mandartResponse);
    }


    /*사용자에 따른 만다라트 목록 조회*/
    @GetMapping("/user/mandarts")
    public ResponseEntity<List<MandartResponse>> findMandartsByUserId() {
        List<MandartResponse> mandartResponses = new ArrayList<>();

        // 사용자에 따른 만다라트 리스트 조회(테스트용으로 birdsilver 아이디로 조회)
        List<Mandart> mandarts = mandartService.findByUserId("birdsilver")
                .orElse(Collections.emptyList())
                .stream()
                .toList();

        // 만다라트id에 따른 목표 리스트 조회
        for (int i = 0; i < mandarts.size(); i++) {
            Mandart mandart = mandarts.get(i);
            MandartResponse mandartResponse = new MandartResponse(mandart);

            /*만다라트에 따른 목표 리스트 조회*/
            List<Goal> goals = goalService.findByMandartId(mandart.getId())
                    .orElse(Collections.emptyList())
                    .stream()
                    .toList();

            // 목표에 따른 action 리스트 조회
            List<GoalResponse> goalResponses = goals
                    .stream()
                    .map(goal -> {
                        GoalResponse goalResponse = new GoalResponse(goal);  // Goal 객체를 GoalResponse 객체로 변환

                        List<Action> actions = actionService.findActionsByGoalId(goal.getId())
                                .orElse(Collections.emptyList());  // 목표에 따른 action 리스트 조회

                        goalResponse.setActionList(actions);  // GoalResponse에 action 리스트 설정

                        return goalResponse;  // 변형된 GoalResponse 객체를 리턴
                    })
                    .toList();

            mandartResponse.setGoalList(goalResponses);
            mandartResponses.add(mandartResponse);
        }

        return ResponseEntity.ok()
                .body(mandartResponses);
    }

    @PostMapping("/mandart/create")
    public long createMandart(@RequestBody Map<String, Object> mandartName) {
        System.out.println("mandartName: " + mandartName.get("mandartName"));
        return mandartService.createMandart(String.valueOf(mandartName.get("mandartName")));
    }
}
