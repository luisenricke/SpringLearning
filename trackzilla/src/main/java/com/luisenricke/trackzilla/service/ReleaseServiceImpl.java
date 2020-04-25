package com.luisenricke.trackzilla.service;

import com.luisenricke.trackzilla.entity.Release;
import com.luisenricke.trackzilla.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReleaseServiceImpl implements ReleaseService {
    @Autowired
    private ReleaseRepository releaseRepository;

    @Override
    public Iterable<Release> listReleases() {
        return releaseRepository.findAll();
    }

}
