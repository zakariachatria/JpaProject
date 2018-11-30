package com.jpaproject.demo.services;

import com.jpaproject.demo.models.PartageList;

public interface PartageListService {
    public void SavePartageListe(PartageList partageList);
    public PartageList getPartageList(Long id);
}
