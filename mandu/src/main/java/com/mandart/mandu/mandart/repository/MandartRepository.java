package com.mandart.mandu.mandart.repository;

import com.mandart.mandu.mandart.domain.Goal;
import com.mandart.mandu.mandart.domain.Mandart;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public interface MandartRepository extends JpaRepository<Mandart, Long> {
    Optional<List<Mandart>> findMandartsByUserId(String userId);
    int countByUserId(String userId);
}
