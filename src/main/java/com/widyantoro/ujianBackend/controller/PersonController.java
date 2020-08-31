package com.widyantoro.ujianBackend.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.widyantoro.ujianBackend.model.dto.MessageDanPersonDto;
import com.widyantoro.ujianBackend.model.dto.messageDto;
import com.widyantoro.ujianBackend.model.dto.personDto;
import com.widyantoro.ujianBackend.model.entity.biodataEntity;
import com.widyantoro.ujianBackend.model.entity.personEntity;
import com.widyantoro.ujianBackend.repository.biodataRepository;
import com.widyantoro.ujianBackend.repository.pendidikanRepository;
import com.widyantoro.ujianBackend.repository.personRepository;
import com.widyantoro.ujianBackend.service.personService;
import com.widyantoro.ujianBackend.service.personServiceImplements;


@RestController
@RequestMapping("/person")
public class PersonController {
	private final personRepository personRepository;
	private final biodataRepository biodataRepository;
	private final pendidikanRepository pendRepository;

    @Autowired
    public PersonController(personRepository personRepository, biodataRepository bio, pendidikanRepository pend) {
        this.personRepository = personRepository;
        this.biodataRepository=bio;
        this.pendRepository=pend;
    }
    @Autowired
    private personService personService;

    // http://localhost:1212/person
    @GetMapping("/{nik}")
    public MappingJacksonValue getDataByNik(@PathVariable String nik) { 
    	messageDto pesan =new messageDto();
    	MessageDanPersonDto person= new MessageDanPersonDto();
    	if (nik.length()!=16) {
    		pesan.setStatus("false");
    		pesan.setMessage("data gagal masuk, jumlah digit tidak sama dengan 16");
    		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("status","message");
    		FilterProvider filters= new SimpleFilterProvider().addFilter("Pesan error nik tidak sama sengan 16", filter);
    		MappingJacksonValue mapp= new MappingJacksonValue(pesan);
    		mapp.setFilters(filters);
    		return mapp;
    	}
    	else if (personRepository.getNikByNik(nik)==null) {
    		pesan.setStatus("false");
    		pesan.setMessage("data gagal masuk" + nik + "tidak terdapat dalam database");
    		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("status","message");
    		FilterProvider filters= new SimpleFilterProvider().addFilter("Pesan Error", filter);
    		MappingJacksonValue mapp= new MappingJacksonValue(pesan);
    		mapp.setFilters(filters);
    		return mapp;
    	}else {
    		person.setNama(personRepository.getNamaByNik(nik));
    		person.setAlamat(personRepository.getAlamatByNik(nik));
    		person.setNik(personRepository.getNikByNik(nik));
    		person.setNoHp(biodataRepository.getNoHpbyNik(nik));
    		person.setTanggalLahir(biodataRepository.getTanggalBynik(nik));
    		person.setTempatLahir(biodataRepository.getTempatByNik(nik));
    	}
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("status","message");
		FilterProvider filters= new SimpleFilterProvider().addFilter("Data Yang Ditampilkan", filter);
		MappingJacksonValue mapp= new MappingJacksonValue(person);
		mapp.setFilters(filters);
		return mapp;
    }
    @PostMapping
    public messageDto insert(@RequestBody personDto dto) {
    	Date date= dto.getTanggalLahir();
    	Calendar n= Calendar.getInstance();
    	n.setTime(date);
    	int tahunLahir= n.get(Calendar.YEAR);
//    	Calendar nm= Calendar.getInstance();
//    	Date nmn= nm.getTime();
//    	n.setTime(nmn);
//    	int tahunSekarang= n.get(Calendar.YEAR);
//    	
//    	
    	
    	if (dto.getNik().length()!=16) {
    		return statusGagalNik();
    		
    	}else if (2020-tahunLahir>=30) {
    		return statusGagalUmur();
    	}
    	else {
    		personEntity person= convertToEntity(dto);
    		personService.insertPerson(person);
    		dto.setIdPerson(person.getIdPerson());
    		biodataEntity bio= convertToEntitybio(dto);
    		personService.insertBiodata(bio);
    	}
    	return statusBerhasil();
    }
    
    private messageDto statusBerhasil() {
    	messageDto dto= new messageDto();
    	dto.setStatus("true");
    	dto.setMessage("Data Behasil Masuk");
    	return dto;
    }
    private messageDto statusGagalNik() {
    	messageDto dto = new messageDto();
    	dto.setStatus("false");
    	dto.setMessage("jumlah nik tidak sama dengan 16 digit");
    	return dto;
    }
    private messageDto statusGagalUmur() {
    	messageDto dto= new messageDto();
    	dto.setStatus("false");
    	dto.setMessage("Umur lebih dari 30 tahun");
    	return dto;
    }
    
    
//    private List<personDto> get() {
//        List<personEntity> personList = personRepository.findAll();
//        List<personDto> personDtoList = personList.stream().map(this::convertToDto)
//                .collect(Collectors.toList());
//        return personDtoList;
//    }
    
//    get by nik
//    @GetMapping("/{nik}")
//    private List<personDto> getNik(@PathVariable String nik) {
//        List<personEntity> personList = personRepository.findByNik(nik);
//        List<personDto> personDtoList = personList.stream().map(this::convertToDto)
//                .collect(Collectors.toList());
//        return personDtoList;
//    }
////status
    
  
//   post mapping
//    /*Insert Data*/
//    @PostMapping
//    public personDto insert(@RequestBody personDto dto) {
//        personEntity persEntity = convertToEntity(dto);
//        biodataEntity bio= convertToEntitybio(dto);
//        personRepository.save(persEntity);
//        biodataRepository.save(bio);
//        return dto;
//    }
//    public personDto insertbio(@RequestBody personDto dto) {
//        biodataEntity persEntity = convertToEntitybio(dto);
//        biodataRepository.save(persEntity);
//        return dto;
//    }
 
  
    public personEntity convertToEntity(personDto dto){
        personEntity personEnt = new personEntity();
        personEnt.setNama(dto.getNama());
        personEnt.setNik(dto.getNik());
        personEnt.setAlamat(dto.getAlamat());
        return personEnt;
    }
  
 
//    private personDto convertToDto(personEntity person){
//        personDto personDto = new personDto();
//        personDto.setIdPerson(person.getIdPerson());
//        personDto.setNama(person.getNama());
//        personDto.setNik(person.getNik());
//        personDto.setAlamat(person.getAlamat());
////        personDto.setTanggalLahir(bio.getTanggalLahir());
////        personDto.setTempatLahir(bio.getTempatLahir());
////        personDto.setNoHp(bio.getNoHp());
//        return personDto;
//    }

    private biodataEntity convertToEntitybio(personDto dto){
        biodataEntity personEnt = new biodataEntity();
        personEnt.setTanggalLahir(dto.getTanggalLahir());
        personEnt.setTempatLahir(dto.getTempatLahir());
        personEnt.setNoHp(dto.getNoHp());
        personEntity person =  personRepository.findById(dto.getIdPerson()).get();
        personEnt.setPersonEntity(person);
        
        return personEnt;
    }

}
