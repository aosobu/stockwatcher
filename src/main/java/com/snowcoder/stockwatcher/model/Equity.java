package com.snowcoder.stockwatcher.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * created by aosobu on 20/07/2020
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Equity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String ticker;
    private String subSector;

    @Column(columnDefinition = "int default 0")
    private Boolean approved = false;

    private Date created_on;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "equity_id")
    private Set<EquityMetrics> equitiyMetrics;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "equity_ytd_id")
    private Set<EquityYtdMetrics> equitiyYtdMetrics;
}
