package com.mandart.mandu.mandart.domain;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Mandart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mandart_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "mandart_name", nullable = false)
    private String name;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Builder
    public Mandart(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }
}
