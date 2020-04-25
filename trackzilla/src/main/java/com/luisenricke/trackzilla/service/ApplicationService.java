package com.luisenricke.trackzilla.service;

import com.luisenricke.trackzilla.entity.Application;

import java.util.List;

public interface ApplicationService {
    List<Application> listApplications();
    Application findApplication(long id);
}
