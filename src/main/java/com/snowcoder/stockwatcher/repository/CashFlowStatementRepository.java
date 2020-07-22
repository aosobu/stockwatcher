package com.snowcoder.stockwatcher.repository;

import com.snowcoder.stockwatcher.model.CashFlowStatement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * created by aosobu on 22/07/2020
 */
@Repository
public interface CashFlowStatementRepository extends JpaRepository<CashFlowStatement, Long> {
}
