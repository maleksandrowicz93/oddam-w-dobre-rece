package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.UserPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Gift;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Organization;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.ShippingInfo;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.GiftDTO;
import com.github.maleksandrowicz93.oddamwdobrerece.services.GiftConverter;
import com.github.maleksandrowicz93.oddamwdobrerece.services.GiftService;
import com.github.maleksandrowicz93.oddamwdobrerece.services.OrganizationService;
import com.github.maleksandrowicz93.oddamwdobrerece.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/app")
public class UserDashboardController {

    private GiftService giftService;
    private OrganizationService organizationService;
    private UserService userService;

    public UserDashboardController(GiftService giftService, OrganizationService organizationService, UserService userService) {
        this.giftService = giftService;
        this.organizationService = organizationService;
        this.userService = userService;
    }

    @GetMapping
    public String displayAdminDashboard(Model model) {
        GiftDTO newGift = new GiftDTO();
        model.addAttribute("newGift", newGift);
        return "user-dashboard";
    }

    @PostMapping
    public void saveAddGiftForm(@ModelAttribute GiftDTO newGift, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        Gift gift = GiftConverter.giftDtoToGift(newGift);
        ShippingInfo shippingInfo = GiftConverter.giftDtoToShippingInfo(newGift);
        gift.setDateOfGiftRegistration(LocalDate.now().toString());
        gift.setDateOfCollection(shippingInfo.getDate());
        gift.setStatus("nieodebrane");
        gift.setShippingInfo(shippingInfo);
        gift.setUser(user);
        giftService.saveGift(gift);
    }

    @ModelAttribute("organizations")
    public List<Organization> findAllOrganizations() {
        return organizationService.findAllOrganizations();
    }
}
