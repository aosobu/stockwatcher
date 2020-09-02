package com.snowcoder.stockwatcher.repository;

import com.snowcoder.stockwatcher.model.AppState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppStateRepository extends JpaRepository<AppState, Long>{

}