package com.mandart.mandu.mandart.dto;

import com.mandart.mandu.mandart.domain.Goal;
import com.mandart.mandu.mandart.domain.Mandart;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class MandartResponse {

    private final long id;
    private final String name;
    private final String userId;
    private List<GoalResponse> goalList;

    public MandartResponse(Mandart mandart) {
        this.id = mandart.getId();
        this.name = mandart.getName();
        this.userId = mandart.getUserId();
    }
}
