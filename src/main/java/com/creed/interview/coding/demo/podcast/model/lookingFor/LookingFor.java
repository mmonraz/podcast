package com.creed.interview.coding.demo.podcast.model.lookingFor;

import javax.persistence.Embeddable;

@Embeddable
public class LookingFor {
    private boolean sponsors;
    private boolean guests;
    private boolean cohosts;
    private boolean cross_promotion;

    public boolean isSponsors() {
        return sponsors;
    }

    public void setSponsors(boolean sponsors) {
        this.sponsors = sponsors;
    }

    public boolean isGuests() {
        return guests;
    }

    public void setGuests(boolean guests) {
        this.guests = guests;
    }

    public boolean isCohosts() {
        return cohosts;
    }

    public void setCohosts(boolean cohosts) {
        this.cohosts = cohosts;
    }

    public boolean isCross_promotion() {
        return cross_promotion;
    }

    public void setCross_promotion(boolean cross_promotion) {
        this.cross_promotion = cross_promotion;
    }

}
