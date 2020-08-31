package com.widyantoro.ujianBackend.service;

import com.widyantoro.ujianBackend.model.entity.BiodataEntity;
import com.widyantoro.ujianBackend.model.entity.PendidikanEntity;
import com.widyantoro.ujianBackend.model.entity.PersonEntity;

public interface PersonService {
	PersonEntity insertPerson(PersonEntity person);
	BiodataEntity insertBiodata(BiodataEntity bio);
	PendidikanEntity insertPendidikan(PendidikanEntity pendidikan);

}
