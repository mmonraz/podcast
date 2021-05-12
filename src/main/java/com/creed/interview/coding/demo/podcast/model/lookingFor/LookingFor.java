package com.creed.interview.coding.demo.podcast.model.lookingFor;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class LookingFor {
    private boolean sponsors;
    private boolean guests;
    private boolean cohosts;
    private boolean cross_promotion;
}
