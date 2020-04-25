package com.luisenricke.trackzilla.service;

import com.luisenricke.trackzilla.entity.Application;
import com.luisenricke.trackzilla.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Iterable<Application> listApplications() {
        return applicationRepository.findAll();
    }

}
