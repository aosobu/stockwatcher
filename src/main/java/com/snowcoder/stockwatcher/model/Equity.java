package com.snowcoder.stockwatcher.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Equity {

    @Id
    @GeneratedValue
    private long id;

    private float priceOpen;
    private float priceClose;
    private float priceChange;
    private float percentagePriceChange;
    private int trades;
    private BigDecimal volume;
    private BigDecimal value;
    private BigDecimal marketCapitalization;
    private BigDecimal outstandingShares;
    private boolean approved;
    private Date created_on;
}
