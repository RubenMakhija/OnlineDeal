package com.example.deal2;

import com.example.deal2.model.Deal;
import com.example.deal2.service.ClaimDealService;
import com.example.deal2.service.CreateDealService;
import com.example.deal2.service.EndDealService;
import com.example.deal2.service.UpdateDealService;

@RestController
@RequestMapping("/deals")
public class DealController {

    //1 .create deal
    //2. end a deal
    //3. update deal.
    //4. claim a deal

    @Autowired
    private CreateDealService createDealService;

    @Autowired
    private EndDealService endDealService;

    @Autowired
    private UpdateDealService updateDealService;

    @Autowired
    private ClaimDealService claimDealService;

    @PostMapping
    public ResponseEntity<?> createDeal(@RequestBody Deal deal) {
        Deal createDeal = createDealService.createDeal(deal);
        return ResponseEntity.ok();

    }

    @PostMapping("/{dealId}/end")
    public ResponseEntity<?> endDeal(@PathVariable UUID dealId) {
        Deal endDeal = endDealService.endDeal(dealId);
        return ResponseEntity.ok();

    }

    @PutMapping("/update-deal")
    public ResponseEntity<?> updateDeal(@PathVariable UUID dealId, @RequestBody Deal deal) {
        Deal updateDeal = updateDealService.updateDeal(dealId, deal.getEndTime(), deal.getQuantity());
        return ResponseEntity.ok();

    }

    @PostMapping("/claim-deal")
    public ResponseEntity<?> claimDeal(@PathVariable UUId dealId, @RequestParam UUID userId) {
        String result = claimDealService.claimdeal(dealId, userId);
        return ResponseEntity.ok();


    }
}