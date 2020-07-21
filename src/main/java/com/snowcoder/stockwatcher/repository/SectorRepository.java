package com.snowcoder.stockwatcher.repository;

import com.snowcoder.stockwatcher.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<Sector, Long> {
}
