package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.UserPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Gift;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.GiftRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/app/gifts")
public class UserGiftsController {

    private GiftRepository giftRepository;

    public UserGiftsController(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
    }

    @GetMapping
    public String displayGiftsPage() {
        return "user-gifts";
    }

    @ModelAttribute("gifts")
    public List<Gift> getAllGifts() {
        return giftRepository.findAll();
    }

}
