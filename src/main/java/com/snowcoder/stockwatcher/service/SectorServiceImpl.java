package com.snowcoder.stockwatcher.service;

import com.snowcoder.stockwatcher.model.Sector;
import com.snowcoder.stockwatcher.repository.SectorRepository;
import com.snowcoder.stockwatcher.service.interfaces.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by aosobu.dev on 26/07/2020.
 */
@Service
public class SectorServiceImpl implements SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    @Override
    public Optional<Sector> findAllByName(String name) {
        return sectorRepository.findByName(name);
    }

    @Override
    public Optional<Sector> findAllById(Long id) {
        return sectorRepository.findById(id);
    }

    @Override
    public List<Sector> getAll() {
        return sectorRepository.findAll();
    }

    public Sector save(Sector sector){
        return sectorRepository.save(sector);
    }

    public List<Sector> saveAll(List<Sector> sectors){
        return sectorRepository.saveAll(sectors);
    }
}
