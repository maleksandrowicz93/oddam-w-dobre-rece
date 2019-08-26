package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.UserPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Gift;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.GiftDTO;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.GiftDtoStatusContext;
import com.github.maleksandrowicz93.oddamwdobrerece.services.GiftService;
import com.github.maleksandrowicz93.oddamwdobrerece.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public String displayGiftInfoPage(@PathVariable("id") Long id, Model model) {
        Gift gift = giftService.findById(id);
        model.addAttribute("gift", gift);
        return "user-gifts-gift";
    }

    @GetMapping("/{id}/editStatus")
    public String displayEditGiftStatusForm(@PathVariable("id") Long id, Model model) {
        if (giftService.findById(id).getStatus().equals("odebrane")) {
            return "redirect:/app/gifts/" + id;
        }
        GiftDtoStatusContext giftDTO = new GiftDtoStatusContext();
        model.addAttribute("giftDTO", giftDTO);
        return "user-gifts-gift-editStatus";
    }

    @PostMapping("/{id}/editStatus")
    public String saveEditGiftStatusForm(@PathVariable("id") Long id, @ModelAttribute GiftDtoStatusContext giftDTO) {
        if (giftDTO.getStatus() == null) {
            giftDTO.setStatus("nieodebrane");
        }
        if (giftDTO.getStatus().equals("odebrane")) {
            Gift gift = giftService.findById(id);
            giftService.changeGiftStatus(gift, giftDTO);
        }
        return "redirect:/app/gifts/" + id;
    }

    @ModelAttribute("gifts")
    public List<Gift> getUserGifts(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return giftService.findSortedGiftsOfUser(user);
    }
}