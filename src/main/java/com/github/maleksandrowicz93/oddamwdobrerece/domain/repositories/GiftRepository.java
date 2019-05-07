package com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftRepository extends JpaRepository<Gift, Long> {
}
