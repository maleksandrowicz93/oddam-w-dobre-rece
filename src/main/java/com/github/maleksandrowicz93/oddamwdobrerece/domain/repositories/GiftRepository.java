package com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GiftRepository extends JpaRepository<Gift, Long> {

    Gift findFirstById(Long id);

    @Query("select g from Gift g order by g.state desc, g.dateOfCollection desc, g.dateOfGiftRegistration")
    List<Gift> readAllSortedGifts();

}
