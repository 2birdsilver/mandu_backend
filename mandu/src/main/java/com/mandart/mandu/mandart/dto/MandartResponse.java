package com.mandart.mandu.mandart.dto;

import com.mandart.mandu.mandart.domain.Mandart;
import lombok.Getter;

@Getter
public class MandartResponse {

    private final long id;
    private final String name;

    public MandartResponse(Mandart mandart) {
        this.id = mandart.getId();
        this.name = mandart.getName();
    }
}
