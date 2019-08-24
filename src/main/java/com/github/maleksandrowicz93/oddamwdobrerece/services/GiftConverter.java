package com.github.maleksandrowicz93.oddamwdobrerece.services;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Gift;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Organization;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.ShippingInfo;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.OrganizationRepository;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.GiftDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GiftConverter {

    private OrganizationService organizationService;

    public static GiftDTO createNewGiftDtoBasedOnGiftForm(
            List<String> products,
            Integer bags,
            String localization,
            List<String> help,
            Organization organization,
            String address,
            String city,
            String postcode,
            String phone,
            String data,
            String time,
            String more_info)
    {
        GiftDTO newGiftDTO = new GiftDTO();
        newGiftDTO.setProducts(products);
        newGiftDTO.setAmountOfBags(bags);
        newGiftDTO.setLocalization(localization);
        newGiftDTO.setHelpFor(help);
        newGiftDTO.setAddress(address);
        newGiftDTO.setCity(city);
        newGiftDTO.setPostcode(postcode);
        newGiftDTO.setPhone(phone);
        newGiftDTO.setDate(data);
        newGiftDTO.setTime(time);
        newGiftDTO.setMoreInfo(more_info);

//        GiftConverter giftConverter = new GiftConverter();
//        Organization chosenOrganization = giftConverter.organizationService.findByName("Dla dzieci");
        newGiftDTO.setOrganization(organization);

        return newGiftDTO;
    }

    public static Gift completeNewGiftData (Gift gift, ShippingInfo shippingInfo, User user) {
        gift.setDateOfGiftRegistration(LocalDate.now().toString());
        gift.setDateOfCollection(shippingInfo.getDate());
        gift.setStatus("nieodebrane");
        gift.setShippingInfo(shippingInfo);
        gift.setUser(user);
        return gift;
    }

    public static Gift giftDtoToGift(GiftDTO giftDTO) {
        Gift gift = new Gift();
        gift.setProducts(giftDTO.getProducts());
        gift.setAmountOfBags(giftDTO.getAmountOfBags());
        gift.setLocalization(giftDTO.getLocalization());
        gift.setHelpFor(giftDTO.getHelpFor());
        gift.setOrganization(giftDTO.getOrganization());
        return gift;
    }

    public static ShippingInfo giftDtoToShippingInfo(GiftDTO giftDTO) {
        ShippingInfo shippingInfo = new ShippingInfo();
        shippingInfo.setAddress(giftDTO.getAddress());
        shippingInfo.setCity(giftDTO.getCity());
        shippingInfo.setPostcode(giftDTO.getPostcode());
        shippingInfo.setPhone(giftDTO.getPhone());
        shippingInfo.setDate(giftDTO.getDate());
        shippingInfo.setTime(giftDTO.getTime());
        shippingInfo.setMoreInfo(giftDTO.getMoreInfo());
        return shippingInfo;
    }

}
