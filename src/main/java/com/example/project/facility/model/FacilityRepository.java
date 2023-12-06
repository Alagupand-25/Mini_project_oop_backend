package com.example.project.facility.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FacilityRepository extends JpaRepository<Facility,Integer> {
	List<Facility> findAll();
	boolean existsByFacilityid(long facility_id);
	Facility getByFacilityid(long facility_id);
}
