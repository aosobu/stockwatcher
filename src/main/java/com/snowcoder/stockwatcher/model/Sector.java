package com.snowcoder.stockwatcher.model;

import com.sun.istack.NotNull;
import com.sun.javafx.beans.IDProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
@NoArgsConstructor
@Getter
@Setter
public class Sector {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String name;
}
