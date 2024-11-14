package com.mandart.mandu.mandart.service;

import com.mandart.mandu.mandart.domain.Goal;
import com.mandart.mandu.mandart.domain.Mandart;
import com.mandart.mandu.mandart.repository.GoalRepository;
import com.mandart.mandu.mandart.repository.MandartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GoalService {

    private final GoalRepository goalRepository;

    public List<Goal> findAll() {
        return goalRepository.findAll();
    }

    public Goal findById(long id) {
        return goalRepository.getReferenceById(id);
    }

    /*만다라트id에 따른 목표 리스트 조회*/
    public Optional<List<Goal>> findByMandartId(long id) { return goalRepository.findByMandartId(id);}

}
