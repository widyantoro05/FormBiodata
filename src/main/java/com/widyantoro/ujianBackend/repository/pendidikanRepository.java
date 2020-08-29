package com.widyantoro.ujianBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.widyantoro.ujianBackend.model.entity.pendidikanEntity;

@Repository
public interface pendidikanRepository extends JpaRepository<pendidikanEntity, Integer> {
//	List<pendidikanEntity> 
//	findAllByIdperson(Integer IdPerson);
}
