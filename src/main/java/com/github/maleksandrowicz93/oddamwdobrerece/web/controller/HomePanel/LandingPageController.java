package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.HomePanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Organization;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.GiftRepository;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.OrganizationRepository;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;
import java.util.List;

@Controller()
public class LandingPageController {

    private GiftRepository giftRepository;
    private OrganizationRepository organizationRepository;
    private UserRepository userRepository;

    public LandingPageController(GiftRepository giftRepository, OrganizationRepository organizationRepository, UserRepository userRepository) {
        this.giftRepository = giftRepository;
        this.organizationRepository = organizationRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String displayLandingPage(Principal principal, Model model) {
        User user;
        if (principal == null) {
            user = new User();
        } else {
            user = userRepository.findFirstByUsername(principal.getName());
        }
        model.addAttribute("user", user);
        return "landing-page";
    }

    @ModelAttribute("bagsAmountOfAllOnes")
    public Long getAmountOgAllBags() {
        return giftRepository.sumAllBags();
    }

    @ModelAttribute("organizationsAmountOfAllOnes")
    public Long getAmountOgAllOrganizations() {
        return organizationRepository.countAllOrganizations();
    }

    @ModelAttribute("gitsAmountOfAllOnes")
    public Long getAmountOgAllGifts() {
        return giftRepository.countAllGifts();
    }

    @ModelAttribute("helpFor")
    public List<String> getWhoGetHelp() { return giftRepository.findAllForWhoHelp(); }

    @ModelAttribute("localizations")
    public List<String> getAllLocalizations() {
        return giftRepository.findLocalizations();
    }

    @ModelAttribute("products")
    public List<String> getAllProducts() {
        return giftRepository.findProducts();
    }

    @ModelAttribute("foundations")
    public List<Organization> getAllFoundations() { return organizationRepository.findAllFoundations(); }

    @ModelAttribute("privateOrganizations")
    public List<Organization> getAllPrivateOrganizations() { return organizationRepository.findAllPrivateOrganztaions(); }

    @ModelAttribute("collects")
    public List<Organization> getAllLocalCollects() { return organizationRepository.findAllLocalCollects(); }

    @ModelAttribute("amountOfAllFoundations")
    public Long getAmountOfAllFoundations() { return organizationRepository.countAllFoundations(); }

    @ModelAttribute("amountOfAllPrivateOrganizations")
    public Long getAmountOfAllPrivateOrganizations() { return organizationRepository.countAllPrivateOrganizations(); }

    @ModelAttribute("amountOfAllCollects")
    public Long getAmountOfAllCollects() { return organizationRepository.countAllCollects(); }
}
