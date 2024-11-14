package com.mandart.mandu.mandart.service;

import com.mandart.mandu.mandart.domain.Action;
import com.mandart.mandu.mandart.domain.Goal;
import com.mandart.mandu.mandart.repository.ActionlRepository;
import com.mandart.mandu.mandart.repository.GoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ActionService {

    private final ActionlRepository actionlRepository;

    /*Goal id에 따른 action 리스트 조회*/
    public Optional<List<Action>> findActionsByGoalId(long goalid) { return actionlRepository.findActionsByGoalId(goalid);}

}
