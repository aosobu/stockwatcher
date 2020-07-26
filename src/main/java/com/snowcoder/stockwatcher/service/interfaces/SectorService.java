package com.snowcoder.stockwatcher.service.interfaces;

import com.snowcoder.stockwatcher.model.Sector;

import java.util.List;
import java.util.Optional;

/**
 * Created by aosobu.dev on 26/07/2020.
 */
public interface SectorService {
    Optional<Sector> findAllByName(String name);
    Optional<Sector> findAllById(Long id);
    List<Sector> getAll();
}
