package com.mandart.mandu.mandart.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Action {
    @Id
    @Column(name = "action_id", updatable = false)
    private Long id;

    @Column(name = "action_name", nullable = false)
    private String name;

    @Column(name = "goal_id", nullable = false)
    private Long goalId;
}
