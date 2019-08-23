package com.github.maleksandrowicz93.oddamwdobrerece.services;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Gift;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.GiftRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftService {

    private GiftRepository giftRepository;

    public GiftService(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
    }

    public Gift findById(Long id) {
        return giftRepository.findFirstById(id);
    }

    public List<Gift> findAllGifts() {
        return giftRepository.readAllSortedGifts();
    }

    public void saveGift(Gift gift) {
        giftRepository.save(gift);
    }


}
