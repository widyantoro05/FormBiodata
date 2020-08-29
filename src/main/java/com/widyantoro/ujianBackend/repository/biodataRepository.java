package com.widyantoro.ujianBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.widyantoro.ujianBackend.model.entity.biodataEntity;

@Repository
public interface biodataRepository extends JpaRepository<biodataEntity, Integer> {
//	List<biodataEntity> findAllbyIdPerson(Integer idPerson);
}
