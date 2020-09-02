package com.snowcoder.stockwatcher.service;

import com.snowcoder.stockwatcher.model.AppState;
import com.snowcoder.stockwatcher.repository.AppStateRepository;
import com.snowcoder.stockwatcher.service.interfaces.AppStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppStateServiceImpl implements AppStateService {

    private AppStateRepository appStateRepository;

    @Override
    public List<AppState> retrieveAppState() {
        return appStateRepository.findAll();
    }

    @Autowired
    public void setAppStateRepository(AppStateRepository appStateRepository) {
        this.appStateRepository = appStateRepository;
    }
}
