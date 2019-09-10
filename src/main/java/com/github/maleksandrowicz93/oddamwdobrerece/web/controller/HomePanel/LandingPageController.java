package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.HomePanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Organization;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.GiftRepository;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.OrganizationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller()
public class LandingPageController {

    private GiftRepository giftRepository;
    private OrganizationRepository organizationRepository;

    public LandingPageController(GiftRepository giftRepository, OrganizationRepository organizationRepository) {
        this.giftRepository = giftRepository;
        this.organizationRepository = organizationRepository;
    }

    @GetMapping("/")
    public String displayLandingPage() {
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

}
