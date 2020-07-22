package com.snowcoder.stockwatcher.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * created by aosobu on 20/07/2020
 */
@Entity
@Table(name="equity_metrics")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EquityMetrics {

    @Id
    @GeneratedValue
    private Long id;

    private float priceOpen;
    private float priceClose;

    @JsonInclude()
    @Transient
    private float priceChange;

    @JsonInclude()
    @Transient
    private float percentagePriceChange;

    private int trades;
    private BigDecimal volume;
    private BigDecimal value;
    private BigDecimal marketCapitalization;
    private BigDecimal outstandingShares;

    @Column(columnDefinition = "int default 0")
    private Boolean approved;

    private Date created_on;
}
