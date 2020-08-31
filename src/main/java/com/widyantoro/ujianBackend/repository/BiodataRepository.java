package com.widyantoro.ujianBackend.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.widyantoro.ujianBackend.model.entity.BiodataEntity;

@Repository
public interface BiodataRepository extends JpaRepository<BiodataEntity, Integer> {
	@Query(value="select nohp from t_biodata bio inner join t_person p on bio.id_person=p.id_person where nik= ?", nativeQuery = true)
	String getNoHpbyNik(String nik);
	@Query(value="select tanggal_lahir from t_biodata b inner join t_person p on b.id_person=p.id_person where nik = ?", nativeQuery = true)
	Date getTanggalBynik(String nik);
	@Query(value="select tempat_lahir from t_biodata b inner join t_person p on b.id_person=p.id_person where nik = ?", nativeQuery = true)
	String getTempatByNik(String nik);
}
