package com.snowcoder.stockwatcher.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * created by aosobu on 21/07/2020
 */

@Entity
@Table(name="cash_flow_statement")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CashFlowStatement {

    @Id
    @GeneratedValue
    private long id;

    private BigDecimal cashFlowFromFinance;
    private BigDecimal cashFlowFromOperations;
    private BigDecimal cashFlowFromActivities;

    @Column(columnDefinition = "int default 0")
    private boolean approved;

    private Date year;
    private Date created_on;
}
