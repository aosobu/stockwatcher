package com.snowcoder.stockwatcher.controller;

import com.snowcoder.stockwatcher.model.Sector;
import com.snowcoder.stockwatcher.service.SectorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by aosobu.dev on 26/07/2020.
 */
@RestController
@RequestMapping("api/v1/sector")
public class SectorController {

    private SectorServiceImpl sectorService;
    private Sector nullSector;

    @GetMapping
    @RequestMapping("/name/{categoryName}")
    public ResponseEntity<Sector> getAllByName(@PathVariable("categoryName") String category) {
        Optional<Sector> sector = sectorService.findAllByName(category);
        if(sector.isPresent())
            return ResponseEntity.ok(sector.get());
        return ResponseEntity.ok(nullSector);
    }

    @GetMapping
    @RequestMapping("/id/{id}")
    public ResponseEntity<Sector> getAllById(@PathVariable("id") Long id){
        Optional<Sector> sector = sectorService.findAllById(id);
        if(sector.isPresent())
            return ResponseEntity.ok(sector.get());
        return ResponseEntity.ok(nullSector);
    }

    @GetMapping
    @RequestMapping("/all")
    public ResponseEntity<List<Sector>> getAllCategories(){
        return ResponseEntity.ok(sectorService.getAll());
    }

    @Autowired
    public void setSectorService(SectorServiceImpl sectorService) {
        this.sectorService = sectorService;
    }

    public SectorController() {
        this.nullSector = new Sector();
        nullSector.setName("Requested category does not exist");
    }
}
