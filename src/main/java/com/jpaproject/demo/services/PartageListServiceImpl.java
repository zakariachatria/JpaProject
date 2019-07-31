package com.jpaproject.demo.services;

import com.jpaproject.demo.models.PartageList;
import com.jpaproject.demo.repositories.PartageListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartageListServiceImpl implements PartageListService {
    @Autowired
    PartageListRepository partageListRepository ;
    @Override
    public void SavePartageListe(PartageList partageList) {
        partageListRepository.save(partageList);
    }

    @Override
    public PartageList getPartageList(Long id) {
        PartageList partageList = null;
        Optional<PartageList> optionalPartageList = partageListRepository.findById(id);
        if(optionalPartageList!=null){
            partageList = optionalPartageList.get();
        }
        return partageList;
    }

	@Override
	public List<PartageList> getPartageListByUserId(Long id) {
		
		return partageListRepository.findByUserId(id);
	}
	@Override
	public List<PartageList> getAll() {
		
		return partageListRepository.findAll();
	}
}
