package com.snowcoder.stockwatcher.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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
public class Sector implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique=true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.EAGER,
               targetEntity = Equity.class,
               mappedBy = "sector")
    private Set<Equity> equities;
}
