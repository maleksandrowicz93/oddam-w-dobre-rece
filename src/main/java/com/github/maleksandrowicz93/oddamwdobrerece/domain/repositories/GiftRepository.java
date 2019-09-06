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
            "order by g.status asc, g.dateOfCollection desc, g.dateOfGiftRegistration desc, g.id desc ")
    List<Gift> readAllSortedGiftsOfGivenUser(@Param("user") User user);

    @Query(value = "select SUM(amount_of_bags) from gifts", nativeQuery = true)
    Long sumAllBags();

    @Query(value = "select COUNT(id) from gifts", nativeQuery = true)
    Long countAllGifts();

    @Query(value = "select product from gift_products where not product = '0' group by product", nativeQuery = true)
    List<String> findProducts();

    @Query(value = "select localization from gifts where not localization = '0' group by localization", nativeQuery = true)
    List<String> findLocalizations();

}
