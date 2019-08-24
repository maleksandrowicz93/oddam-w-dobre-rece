package com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Gift;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GiftRepository extends JpaRepository<Gift, Long> {

    Gift findFirstById(Long id);

    @Query("select g from Gift g where g.user = :user " +
            "order by g.status desc, g.dateOfCollection desc, g.dateOfGiftRegistration desc, g.id desc ")
    List<Gift> readAllSortedGiftsOfGivenUser(@Param("user") User user);

}
