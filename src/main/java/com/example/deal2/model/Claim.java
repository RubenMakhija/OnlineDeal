package com.example.deal2.model;

import java.util.UUID;

@Entity
public class Claim {

    private UUID id;
    private UUID dealID;
    private UUID userId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getDealID() {
        return dealID;
    }

    public void setDealID(UUID dealID) {
        this.dealID = dealID;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
