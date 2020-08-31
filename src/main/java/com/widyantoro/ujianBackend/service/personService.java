package com.widyantoro.ujianBackend.service;

import com.widyantoro.ujianBackend.model.entity.biodataEntity;
import com.widyantoro.ujianBackend.model.entity.pendidikanEntity;
import com.widyantoro.ujianBackend.model.entity.personEntity;

public interface personService {
	personEntity insertPerson(personEntity person);
	biodataEntity insertBiodata(biodataEntity bio);
	pendidikanEntity insertPendidikan(pendidikanEntity pendidikan);

}
