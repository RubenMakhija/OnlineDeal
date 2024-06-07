package com.example.deal2.service;

import java.time.LocalDateTime;
import java.util.UUID;

import com.example.deal2.model.Deal;
import com.example.deal2.repository.DealRepository;

public class UpdateDealService {

    @Autowired
    DealRepository dealRepository;

    public Deal updateDeal(UUID dealId, LocalDateTime endtime, int quantity) {

        Deal deal = dealRepository.findById(dealId);

        if(deal != null) {
            deal.setEndTime(endtime);
            int additionalQuantity = quantity - deal.getQuantity();
            deal.setRemainingQuantity(deal.getRemainingQuantity() + additionalQuantity);
            dealRepository.save(deal);

        }
        return deal;

    }
}
