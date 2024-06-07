package com.example.deal2.service;

import com.example.deal2.model.Deal;
import com.example.deal2.repository.DealRepository;

public class CreateDealService {

    @Autowired
    DealRepository dealRepository;

    public Deal createDeal(Deal deal) {
        deal.setRemainingQuantity(deal.getQuantity());
        return dealRepository.save(deal);

    }

}
