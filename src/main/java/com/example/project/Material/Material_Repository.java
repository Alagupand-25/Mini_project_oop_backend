package com.example.project.Material;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Subject.Subject;

@Repository
public interface Material_Repository extends JpaRepository<Material, Long>{
	List<Material> findBySubject(Subject subject);
}
