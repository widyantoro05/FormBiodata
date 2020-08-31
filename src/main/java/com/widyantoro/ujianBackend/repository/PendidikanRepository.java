package com.widyantoro.ujianBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.widyantoro.ujianBackend.model.entity.PendidikanEntity;

@Repository
public interface PendidikanRepository extends JpaRepository<PendidikanEntity, Integer> {
	@Query(value="select jenjang_pendidikan from t_pendidikan p inner join t_person pe on p.id_person=pe.id_person where nik= ?", nativeQuery=true )
	String getJenjangbyNik(String nik);
}
