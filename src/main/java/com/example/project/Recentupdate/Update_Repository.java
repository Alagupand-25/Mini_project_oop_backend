package com.example.project.Recentupdate;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Date;


public interface Update_Repository extends JpaRepository<Recent_update,Integer>{
	ArrayList<Recent_update> findByIsdisplayTrueAndExpireatAfter(Date currentDate);
	ArrayList<Recent_update> findByIsdisplayTrueAndIsfacilityonlyFalseAndExpireatAfter(Date currentDate);
}
