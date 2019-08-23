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
    public String displayAddGiftForm() {
        return "user-gifts-add";
    }

    @PostMapping
    public String saveAddGiftForm(
            @RequestParam(defaultValue = "") String products,
            @RequestParam Integer bags,
            @RequestParam String localization,
            @RequestParam(defaultValue = "") String help,
            @RequestParam String organizationSearch,
            @RequestParam(defaultValue = "") String organization,
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

        User user = new User();
        user.setId(1L);
        user.setUsername("m@m.m");
        user.setFirstName("m");
        user.setLastName("m");
        user.setPassword("mmmm");
        user.setRole("USER");
        userService.saveUser(user);
        Organization org = new Organization(1L, "org", "org", "Radom",
                "sosnowiecka 69", "pomagamy", "wszyscy", new ArrayList<>());
        organizationService.saveOrganization(org);
//        User user = userService.findByUsername(principal.getName());
        GiftDTO newGiftDTO = GiftConverter.createNewGiftDtoBasedOnGiftForm(productList, bags, localization,
                helpList, org, address, city, postcode, phone, date, time, moreInfo);
        Gift newGift = GiftConverter.giftDtoToGift(newGiftDTO);
        ShippingInfo shippingInfo = GiftConverter.giftDtoToShippingInfo(newGiftDTO);
        Gift gift = GiftConverter.completeNewGiftData(newGift, shippingInfo, user);

        giftService.saveGift(gift);

        System.out.println(
                "user: " + user.getUsername() + "\n" +
                        "products: " + products + "\n" +
                        "bags: " + bags + "\n" +
                        "localization: " + localization + "\n" +
                        "help: " + help + "\n" +
                        "proposed organization: " + organizationSearch + "\n" +
                        "chosen organization: " + organization + "\n" +
                        "address: " + address + "\n" +
                        "city: " + city + "\n" +
                        "post code: " + postcode + "\n" +
                        "phone: " + phone + "\n" +
                        "date: " + date + "\n" +
                        "time: " + time + "\n" +
                        "info: " + moreInfo
        );
        System.out.println();
        System.out.println(
                "user: " + gift.getUser().getUsername() + "\n" +
                        "products: " + gift.getProducts() + "\n" +
                        "bags: " + gift.getAmountOfBags() + "\n" +
                        "localization: " + gift.getLocalization() + "\n" +
                        "help: " + gift.getHelpFor() + "\n" +
                        "organization: " + gift.getOrganization().getName() + "\n" +
                        "address: " + gift.getShippingInfo().getAddress() + "\n" +
                        "city: " + gift.getShippingInfo().getCity() + "\n" +
                        "post code: " + gift.getShippingInfo().getPostcode() + "\n" +
                        "phone: " + gift.getShippingInfo().getPhone() + "\n" +
                        "date: " + gift.getShippingInfo().getDate() + "\n" +
                        "time: " + gift.getShippingInfo().getTime() + "\n" +
                        "info: " + gift.getShippingInfo().getMoreInfo()
        );

        return "redirect:/app/giftSummary";

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
        System.out.println("dziala");
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
