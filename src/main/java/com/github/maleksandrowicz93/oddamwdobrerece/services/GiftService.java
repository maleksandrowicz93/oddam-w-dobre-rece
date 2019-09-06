package com.github.maleksandrowicz93.oddamwdobrerece.services;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Gift;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.GiftRepository;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.GiftDTO;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.GiftDtoStatusContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftService {

    private static final Logger logger = LoggerFactory.getLogger(GiftService.class);

    private GiftRepository giftRepository;

    public GiftService(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
    }

    public Gift findById(Long id) {
        return giftRepository.findFirstById(id);
    }

    public List<Gift> findSortedGiftsOfUser(User user) {
        return giftRepository.readAllSortedGiftsOfGivenUser(user);
    }

    public void saveGift(Gift gift) {
        giftRepository.save(gift);
        logger.info("Zarejestrowano dar: \n" + gift.toString());
    }

    public void changeGiftStatus(Gift gift, GiftDtoStatusContext giftDTO) {
        gift.setStatus(giftDTO.getStatus());
        giftRepository.save(gift);
        logger.info("Zmieniono status daru na odebrany");
    }
}
