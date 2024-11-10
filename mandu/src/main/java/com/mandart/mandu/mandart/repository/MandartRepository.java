package com.mandart.mandu.mandart.repository;

import com.mandart.mandu.mandart.domain.Mandart;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public interface MandartRepository extends JpaRepository<Mandart, Long> {
}
