package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.HomePanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.GiftRepository;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.OrganizationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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


}
