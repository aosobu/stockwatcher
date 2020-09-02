package com.snowcoder.stockwatcher.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
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
public class EquityMetrics implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @JsonInclude()
    @Transient
    private String ticker;

    private float priceOpen;
    private float priceClose;

    @JsonInclude()
    @Transient
    private float priceChange;

    @JsonInclude()
    @Transient
    private float percentagePriceChange;

    private BigDecimal trades;
    private BigDecimal volume;
    private BigDecimal value;
    private BigDecimal marketCapitalization;
    private BigDecimal outstandingShares;
    private float ytd_high;
    private float ytd_low;

    @Column(columnDefinition = "int default 0")
    private Boolean approved = false;

    @ManyToOne
    @JoinColumn(name = "equity_id")
    private Equity equity;

    private Date created_on;
}
