package com.snowcoder.stockwatcher.repository;

import com.snowcoder.stockwatcher.model.EquityYtdMetrics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquityYtdMetricsRepository extends JpaRepository<EquityYtdMetrics, Long> {
}
