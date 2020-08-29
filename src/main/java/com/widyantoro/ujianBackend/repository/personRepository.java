package com.widyantoro.ujianBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.widyantoro.ujianBackend.model.entity.personEntity;

@Repository
public interface personRepository extends JpaRepository<personEntity, Integer> {
	List
	<personEntity> findByNik(String nik);
	
}
