package com.mandart.mandu.mandart.domain;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Goal {
    @Id
    @Column(name = "goal_id", updatable = false)
    private Long id;

    @Column(name = "goal_name", nullable = false)
    private String name;

    @Column(name = "mandart_id", nullable = false)
    private Long mandartId;

}
