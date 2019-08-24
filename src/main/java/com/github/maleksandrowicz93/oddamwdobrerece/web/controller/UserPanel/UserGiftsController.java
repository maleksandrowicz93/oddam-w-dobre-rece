package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.UserPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Gift;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.services.GiftService;
import com.github.maleksandrowicz93.oddamwdobrerece.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/app/gifts")
public class UserGiftsController {

    private GiftService giftService;
    private UserService userService;

    public UserGiftsController(GiftService giftService, UserService userService) {
        this.giftService = giftService;
        this.userService = userService;
    }

    @GetMapping
    public String displayGiftsPage() { return "user-gifts"; }

    @GetMapping("/info/{id}")
    public String displayGiftInfoPage(@PathVariable("id") Long id, Model model) {
        getGiftByIdAndSendAsAttribute(id, model);
        return "user-gifts-gift";
    }

    @GetMapping("info/{id}/editStatus")
    public String displayEditGiftStatusForm(@PathVariable("id") Long id, Model model) {
        getGiftByIdAndSendAsAttribute(id, model);
        return "user-gifts-gift-editStatus";
    }

    @ModelAttribute("gifts")
    public List<Gift> getUserGifts(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return giftService.findSortedGiftsOfUser(user);
    }

    private void getGiftByIdAndSendAsAttribute(Long id, Model model) {
        Gift gift = giftService.findById(id);
        model.addAttribute("gift", gift);
    }

}