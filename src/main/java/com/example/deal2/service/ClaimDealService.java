package com.example.deal2.service;

import java.time.LocalDateTime;
import java.util.UUID;

import com.example.deal2.model.Claim;
import com.example.deal2.model.Deal;
import com.example.deal2.repository.ClaimRepository;
import com.example.deal2.repository.DealRepository;

public class ClaimDealService {

    @Autowired
    DealRepository dealRepository;

    @Autowired
    ClaimRepository claimRepository;

    public String claimdeal(UUID dealId, UUID userId) {

        Deal deal = dealRepository.findById(dealId);

        if(deal != null) {
            if (deal.getEndTime().isBefore(LocalDateTime.now())) {
                return "deal ended";
            }

            if (deal.getRemainingQuantity() <= 0) {
                return "sold out.";
            }
            Claim claim = new Claim();
            claim.setDealID(dealId);
            claim.setUserId(userId);
            claimRepository.save(claim);

            deal.setRemainingQuantity(deal.getRemainingQuantity() - 1);
            dealRepository.save();

            return  "successful";

        }
        return " deal not present";
    }

}
