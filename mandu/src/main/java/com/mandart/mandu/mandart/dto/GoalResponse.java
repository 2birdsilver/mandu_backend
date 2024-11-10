package com.mandart.mandu.mandart.dto;

import com.mandart.mandu.mandart.domain.Goal;
import com.mandart.mandu.mandart.domain.Mandart;
import lombok.Getter;

@Getter
public class GoalResponse {

    private final long id;
    private final String name;
    private final String action;
    private final long mandartId;

    public GoalResponse(Goal goal) {
        this.id = goal.getId();
        this.name = goal.getName();
        this.action = goal.getAction();
        this.mandartId = goal.getMandartId();
    }
}
