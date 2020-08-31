package com.widyantoro.ujianBackend.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widyantoro.ujianBackend.model.entity.biodataEntity;
import com.widyantoro.ujianBackend.model.entity.pendidikanEntity;
import com.widyantoro.ujianBackend.model.entity.personEntity;
import com.widyantoro.ujianBackend.repository.biodataRepository;
import com.widyantoro.ujianBackend.repository.pendidikanRepository;
import com.widyantoro.ujianBackend.repository.personRepository;
@Transactional
@Service
public class personServiceImplements implements personService{
	@Autowired
	private personRepository persRepo;
	@Autowired
	private biodataRepository bioRepo;
	@Autowired
	private pendidikanRepository pendidikanku;
	
	@Override
	public biodataEntity insertBiodata(biodataEntity bio) {
		biodataEntity en=bioRepo.save(bio);
		return en;
	}
	@Override
	public pendidikanEntity insertPendidikan(pendidikanEntity pendidikan) {
		pendidikanEntity en=pendidikanku.save(pendidikan);
		return en;
	}
	@Override
	public personEntity insertPerson(personEntity person) {
		personEntity en= persRepo.save(person);
		
		return en;
		
	}

}
