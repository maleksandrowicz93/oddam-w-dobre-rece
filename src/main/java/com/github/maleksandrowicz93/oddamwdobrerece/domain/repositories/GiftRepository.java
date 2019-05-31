package com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Gift;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Organization;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftRepository extends JpaRepository<Gift, Long> {

    Gift findFirstById(Long id);

}
