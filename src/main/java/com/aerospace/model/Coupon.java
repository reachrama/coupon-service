package com.aerospace.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Coupon extends AbstractEntity<Long> {

    private String code;
    private BigDecimal discount;
    @Column(name="exp_date")
    private String expiryDate;
}
