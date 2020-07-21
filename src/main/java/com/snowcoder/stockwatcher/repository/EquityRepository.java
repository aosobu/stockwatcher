package com.snowcoder.stockwatcher.repository;

import com.snowcoder.stockwatcher.model.Equity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * created by aosobu on 21/07/2020
 */
@Repository
public interface EquityRepository extends JpaRepository<Equity, Long> {

}
