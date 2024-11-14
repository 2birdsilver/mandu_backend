package com.mandart.mandu.mandart.dto;

import com.mandart.mandu.mandart.domain.Action;
import com.mandart.mandu.mandart.domain.Goal;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GoalResponse {

    private final long id;
    private final String name;
    private final long mandartId;
    private List<Action> actions;

    public GoalResponse(Goal goal) {
        this.id = goal.getId();
        this.name = goal.getName();
        this.mandartId = goal.getMandartId();
    }
}
