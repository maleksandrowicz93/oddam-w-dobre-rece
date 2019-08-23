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
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
    public String displayAddGiftForm() { return "user-gifts-add"; }

    @PostMapping
    public String saveAddGiftForm(
            @RequestParam(defaultValue = "") String products,
            @RequestParam Integer bags,
            @RequestParam String localization,
            @RequestParam(defaultValue = "") String help,
            @RequestParam String organizationSearch,
            @RequestParam(defaultValue = "") Long organizationId,
            @RequestParam String address,
            @RequestParam String city,
            @RequestParam String postcode,
            @RequestParam String phone,
            @RequestParam String date,
            @RequestParam String time,
            @RequestParam String moreInfo,
            Principal principal
    ) {

        List<String> productList = getListFromString(products);
        List<String> helpList = getListFromString(help);
        Gift gift = prepareGiftToSave(principal, productList, bags, localization, helpList, organizationId,
                address, city, postcode, phone, date, time, moreInfo);
        giftService.saveGift(gift);
        return "redirect:/app/giftSummary";

    }

    private Gift prepareGiftToSave(Principal principal, List<String> productList, Integer bags, String localization,
                                   List<String> helpList, Long organizationId, String address, String city,
                                   String postcode, String phone, String date, String time, String moreInfo) {
        User user = userService.findByUsername(principal.getName());
        Organization organization = organizationService.findById(organizationId);
        GiftDTO newGiftDTO = GiftConverter.createNewGiftDtoBasedOnGiftForm(productList, bags, localization,
                helpList, organization, address, city, postcode, phone, date, time, moreInfo);
        Gift newGift = GiftConverter.giftDtoToGift(newGiftDTO);
        ShippingInfo shippingInfo = GiftConverter.giftDtoToShippingInfo(newGiftDTO);
        return GiftConverter.completeNewGiftData(newGift, shippingInfo, user);
    }

    private List<String> getListFromString(String string) {
        List<String> list = new ArrayList<>();
        StringTokenizer tokens = new StringTokenizer(string, ", ");
        while (tokens.hasMoreTokens()) {
            list.add(tokens.nextToken());
        }
        return list;
    }

    @GetMapping("/giftSummary")
    public String success() {
        return "user-gifts-summary";
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
