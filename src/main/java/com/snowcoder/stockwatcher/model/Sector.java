package com.snowcoder.stockwatcher.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * created by aosobu on 20/07/2020
 */

@Entity
@Table(name="category")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Sector {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "sector_id")
    private Set<Equity> equities;
}
