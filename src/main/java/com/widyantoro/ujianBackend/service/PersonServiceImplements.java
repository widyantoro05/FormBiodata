package com.widyantoro.ujianBackend.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widyantoro.ujianBackend.model.entity.BiodataEntity;
import com.widyantoro.ujianBackend.model.entity.PendidikanEntity;
import com.widyantoro.ujianBackend.model.entity.PersonEntity;
import com.widyantoro.ujianBackend.repository.BiodataRepository;
import com.widyantoro.ujianBackend.repository.PendidikanRepository;
import com.widyantoro.ujianBackend.repository.PersonRepository;
@Transactional
@Service
public class PersonServiceImplements implements PersonService{
	@Autowired
	private PersonRepository persRepo;
	@Autowired
	private BiodataRepository bioRepo;
	@Autowired
	private PendidikanRepository pendidikanku;
	
	@Override
	public BiodataEntity insertBiodata(BiodataEntity bio) {
		BiodataEntity en=bioRepo.save(bio);
		return en;
	}
	@Override
	public PendidikanEntity insertPendidikan(PendidikanEntity pendidikan) {
		PendidikanEntity en=pendidikanku.save(pendidikan);
		return en;
	}
	@Override
	public PersonEntity insertPerson(PersonEntity person) {
		PersonEntity en= persRepo.save(person);
		
		return en;
		
	}

}
