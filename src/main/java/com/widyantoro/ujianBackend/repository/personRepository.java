package com.widyantoro.ujianBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.widyantoro.ujianBackend.model.entity.personEntity;

@Repository
public interface personRepository extends JpaRepository<personEntity, Integer> {
	@Query(value=" select alamat from t_person where nik=?", nativeQuery = true)
	String getAlamatByNik(String nik);
	@Query(value="select nama from t_person where nik = ?", nativeQuery = true)
	String getNamaByNik(String nik);
	@Query(value="select nik from t_person where nik = ?", nativeQuery = true)
	String getNikByNik(String nik);
	
	
}
