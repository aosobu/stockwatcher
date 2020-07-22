package com.snowcoder.stockwatcher.repository;

import com.snowcoder.stockwatcher.model.EquityMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * created by aosobu on 22/07/2020
 */
@Repository
public interface EquityMetricsRepository extends JpaRepository<EquityMetrics, Long> {
}
