package com.jpaproject.demo.services;

import java.util.List;

import com.jpaproject.demo.models.PartageList;

public interface PartageListService {
    public void SavePartageListe(PartageList partageList);
    public PartageList getPartageList(Long id);
    public List<PartageList> getPartageListByUserId(Long id);
	public List<PartageList> getAll();
}
