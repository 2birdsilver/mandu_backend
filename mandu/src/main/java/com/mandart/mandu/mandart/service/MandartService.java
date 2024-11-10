package com.mandart.mandu.mandart.service;

import com.mandart.mandu.mandart.domain.Mandart;
import com.mandart.mandu.mandart.repository.MandartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MandartService {

    private final MandartRepository mandartRepository;

    public List<Mandart> findAll() {
        return mandartRepository.findAll();
    }

    public Mandart findById(long id) {
        return mandartRepository.getReferenceById(id);
    }
}
