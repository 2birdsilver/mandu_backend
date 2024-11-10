package com.mandart.mandu.mandart.controller;

import com.mandart.mandu.mandart.dto.MandartResponse;
import com.mandart.mandu.mandart.domain.Mandart;
import com.mandart.mandu.mandart.service.MandartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MandartApiController {

    private final MandartService mandartService;

    @GetMapping("/api/mandarts")
    public ResponseEntity<List<MandartResponse>> findAllMandarts() {
        List<MandartResponse> mandarts = mandartService.findAll()
                .stream()
                .map(MandartResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(mandarts);
    }

    @GetMapping("/api/mandart/{id}")
    public ResponseEntity<MandartResponse> findMandartById(@PathVariable long id) {
        Mandart mandart = mandartService.findById(id);

        return ResponseEntity.ok()
                .body(new MandartResponse(mandart));
    }
}
