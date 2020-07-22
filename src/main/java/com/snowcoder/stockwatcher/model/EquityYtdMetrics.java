package com.snowcoder.stockwatcher.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * created by aosobu on 20/07/2020
 */
@Entity
@Table(name="equity_ytd_metrics")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EquityYtdMetrics {

    @Id
    @GeneratedValue
    private Long id;

    private double ytd_high;
    private double ytd_low;

    private Date created_on;
    private Date modified_on;
}
