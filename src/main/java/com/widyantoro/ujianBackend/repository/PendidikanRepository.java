package com.widyantoro.ujianBackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.widyantoro.ujianBackend.model.entity.PendidikanEntity;

@Repository
public interface PendidikanRepository extends JpaRepository<PendidikanEntity, Integer> {
	@Query(value="select jenjang_pendidikan from t_pendidikan p inner join t_person pp on p.id_person = pp.id_person where nik= ? order by tahun_lulus asc limit 1", nativeQuery=true )
	String getJenjangTerakhirbyNik(String nik);
}
				