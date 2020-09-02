package com.snowcoder.stockwatcher.repository;

import com.snowcoder.stockwatcher.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * created by aosobu on 22/07/2020
 */
@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {

    @Query()
    Optional<Sector> findByName(String name);
}
