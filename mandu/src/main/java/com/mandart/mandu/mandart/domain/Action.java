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
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "action", nullable = false)
    private String action;

    @Column(name = "goal_id", nullable = false)
    private Long goalId;
}
