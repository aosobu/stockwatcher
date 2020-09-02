package com.snowcoder.stockwatcher.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * created by aosobu on 20/07/2020
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Equity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String ticker;
    private String subSector;

    @Column(columnDefinition = "int default 0")
    private Boolean approved = false;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Sector sector;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = EquityMetrics.class, mappedBy = "equity")
    private List<EquityMetrics> equityMetrics;

    private Date created_on;
}
