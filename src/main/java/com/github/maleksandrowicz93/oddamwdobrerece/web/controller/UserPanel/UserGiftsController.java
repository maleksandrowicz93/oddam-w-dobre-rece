package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.UserPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Gift;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.GiftRepository;
import com.github.maleksandrowicz93.oddamwdobrerece.services.GiftService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/app/gifts")
public class UserGiftsController {

    private GiftService giftService;

    public UserGiftsController(GiftService giftService) {
        this.giftService = giftService;
    }

    @GetMapping
    public String displayGiftsPage() {
        return "user-gifts";
    }

    @GetMapping("/info/{id}")
    public String displayGiftInfoPage(@PathVariable("id") Long id, Model model) {
        Gift gift = giftService.findById(id);
        model.addAttribute("gift", gift);
        return "user-gifts-gift";
    }

    @ModelAttribute("gifts")
    public List<Gift> getAllGifts() {
        return giftService.findAllGifts();
    }

}
