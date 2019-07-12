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
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class UserDashboardController {

    private static final Logger logger = Logger.getLogger(UserDashboardController.class);

    private GiftService giftService;
    private OrganizationService organizationService;
    private UserService userService;

    public UserDashboardController(GiftService giftService, OrganizationService organizationService, UserService userService) {
        this.giftService = giftService;
        this.organizationService = organizationService;
        this.userService = userService;
    }

    @GetMapping
    public String displayAddGiftForm() {
        logger.info("hello world");
        System.out.println("hello world");
        return "user-gifts-add";
    }

    @PostMapping
    public String saveAddGiftForm(@RequestParam List<String> products, @RequestParam Integer bags,
                                @RequestParam String localization, @RequestParam List<String> help,
                                @RequestParam String organization_search, @RequestParam String organization,
                                @RequestParam String address, @RequestParam String city, @RequestParam String postcode,
                                @RequestParam String phone, @RequestParam String data,
                                @RequestParam String time, @RequestParam String more_info, Principal principal) {

//        logger.info("bags = " + bags + ", address = " + address);
        System.out.println("bags = " + bags + ", address = " + address);

        User user = userService.findByUsername(principal.getName());
        GiftDTO newGiftDTO = GiftConverter.createNewGiftDtoBasedOnGiftForm(products, bags, localization,
                help, organization, address, city, postcode, phone, data, time, more_info);
        Gift newGift = GiftConverter.giftDtoToGift(newGiftDTO);
        ShippingInfo shippingInfo = GiftConverter.giftDtoToShippingInfo(newGiftDTO);
        Gift gift = GiftConverter.completeNewGiftData(newGift, shippingInfo, user);

//        logger.info("user = " + user + ", localization = " + gift.getLocalization() + ", status = " + gift.getStatus());
        System.out.println("user = " + user + ", localization = " + gift.getLocalization() + ", status = " + gift.getStatus());

        giftService.saveGift(gift);
        return "redirect:/app/giftSummary";

    }

    @GetMapping("/giftSummary")
    public String success() {
        System.out.println("dziala");
        return "dashboard";
    }

    @ModelAttribute("organizations")
    public List<Organization> findAllOrganizations() {
        return organizationService.findAllOrganizations();
    }

    @ModelAttribute("products")
    public List<String> getProducts() {
        List<String> products = new ArrayList<>();
        products.add("1");
        products.add("2");
        return products;
    }
}
