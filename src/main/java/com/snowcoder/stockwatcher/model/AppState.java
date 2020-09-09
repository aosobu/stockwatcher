package com.snowcoder.stockwatcher.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "app_state")
public class AppState {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Boolean databaseIsFilled;
    private Boolean isSectorTableFilled;
    private Boolean isEquityTableFIlled;
    private String lastDatePullDate;
}
