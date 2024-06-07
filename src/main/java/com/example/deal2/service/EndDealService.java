package com.example.deal2.service;

import java.time.LocalDateTime;
import java.util.UUID;

import com.example.deal2.model.Deal;
import com.example.deal2.repository.DealRepository;

public class EndDealService {

    @Autowired
    DealRepository dealRepository;

    public Deal endDeal(UUID dealId) {
        Deal deal = dealRepository.findById(dealId);

        if(deal != null) {
            deal.setEndTime(LocalDateTime.now());
            dealRepository.save(deal);

        }
        return deal;
    }
}
