package com.jpaproject.demo.repositories;

import com.jpaproject.demo.models.PartageList;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartageListRepository extends JpaRepository<PartageList,Long> {
	public List<PartageList> findByUserId(Long Id);
}
