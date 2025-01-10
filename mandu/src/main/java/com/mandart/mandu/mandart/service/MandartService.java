package com.mandart.mandu.mandart.service;

import com.mandart.mandu.mandart.domain.Mandart;
import com.mandart.mandu.mandart.repository.MandartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MandartService {

    private final MandartRepository mandartRepository;

    /*모든 만다라트 조회(테스트용)*/
    public List<Mandart> findAll() {
        return mandartRepository.findAll();
    }

    /*만다라트id로 만다라트 조회*/
    public Mandart findById(long id) {
        return mandartRepository.getReferenceById(id);
    }

    /*사용자id에 따른 만다라트 리스트 조회*/
    public Optional<List<Mandart>> findByUserId(String userId) {
        return mandartRepository.findMandartsByUserId((userId));
    }

    public int MandartCountByUserId(String userId) {
        return mandartRepository.countByUserId(userId);
    }

    public long createMandart(String mandartName) {
        int mandartCount = MandartCountByUserId("birdsilver");
        Mandart mandart = Mandart.builder().name(mandartName).userId("birdsilver").build();
        Mandart savedMandart = mandartRepository.save(mandart);
        return savedMandart.getId();
    }



}
