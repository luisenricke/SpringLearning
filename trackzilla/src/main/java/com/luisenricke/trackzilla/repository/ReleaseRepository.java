package com.luisenricke.trackzilla.repository;

import com.luisenricke.trackzilla.entity.Release;
import org.springframework.data.repository.CrudRepository;

public interface ReleaseRepository extends CrudRepository<Release, Long> {
}
