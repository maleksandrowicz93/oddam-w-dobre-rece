package com.github.maleksandrowicz93.oddamwdobrerece.services;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Gift;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.ShippingInfo;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.GiftDTO;

public class GiftConverter {

    public static Gift giftDtoToGift(GiftDTO giftDTO) {
        Gift gift = new Gift();
        gift.setName(giftDTO.getName());
        gift.setAmountOfBags(giftDTO.getAmountOfBags());
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
