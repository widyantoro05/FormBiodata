package com.widyantoro.ujianBackend.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
import com.widyantoro.ujianBackend.model.dto.BiodataDtoGet;
import com.widyantoro.ujianBackend.model.dto.MessageDanPersonDto;
import com.widyantoro.ujianBackend.model.dto.MessageDto;
import com.widyantoro.ujianBackend.model.dto.PersonDto;
import com.widyantoro.ujianBackend.model.entity.BiodataEntity;
import com.widyantoro.ujianBackend.model.entity.PersonEntity;
import com.widyantoro.ujianBackend.repository.BiodataRepository;
import com.widyantoro.ujianBackend.repository.PendidikanRepository;
import com.widyantoro.ujianBackend.repository.PersonRepository;
import com.widyantoro.ujianBackend.service.PersonService;


@RestController
@RequestMapping("/person")
public class PersonController {
	private final PersonRepository personRepository;
	private final BiodataRepository biodataRepository;
	private final PendidikanRepository pendRepository;

    @Autowired
    public PersonController(PersonRepository personRepository, BiodataRepository bio, PendidikanRepository pend) {
        this.personRepository = personRepository;
        this.biodataRepository=bio;
        this.pendRepository=pend;
    }
    @Autowired
    private PersonService personService;


    public PersonDto getData(PersonEntity person	){
        PersonDto personDto = new PersonDto();
        personDto.setNama(person.getNama());
        personDto.setNik(person.getNik());
        personDto.setAlamat(person.getAlamat());
        return personDto;
    }
    public BiodataDtoGet getData2(BiodataEntity bio){
        BiodataDtoGet personDto = new BiodataDtoGet();
        personDto.setTanggalLahir(bio.getTanggalLahir());
        personDto.setNoHp(bio.getNoHp());
        personDto.setTempatLahir(bio.getTempatLahir());
        return personDto;
    }
    @GetMapping
    public List<PersonDto> get() {
           List<PersonEntity> personList = (personRepository.findAll());
           List<PersonDto> coba= new ArrayList<>();
           for (PersonEntity b: personList) {
        	   PersonDto dto= new PersonDto();
        	   dto.setIdPerson(b.getIdPerson());
        	   dto.setAlamat(b.getAlamat());
        	   dto.setNama(b.getNama());
        	   dto.setNik(b.getNik());
        	   dto.setNoHp(biodataRepository.getNoHpbyNik(b.getNik()));
        	   dto.setTanggalLahir(biodataRepository.getTanggalBynik(b.getNik()));
        	   dto.setTempatLahir(biodataRepository.getTempatByNik(b.getNik()));
        	   coba.add(dto);
           }
           return coba;
    }
    @GetMapping("/biodata/{nik}")
    public MappingJacksonValue getDataByNik(@PathVariable String nik) { 
    	MessageDto pesan =new MessageDto();
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
    		pesan.setMessage("data gagal masuk" +" "+ nik +" "+ "tidak terdapat dalam database");
    		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("status","message");
    		FilterProvider filters= new SimpleFilterProvider().addFilter("Pesan Error tidak ada niknya", filter);
    		MappingJacksonValue mapp= new MappingJacksonValue(pesan);
    		mapp.setFilters(filters);
    		return mapp;
    	}else {
    		person.setStatus("true");
    		person.setMessage("Behasil, Ada data dengan nik :" +nik);
    		person.setNama(personRepository.getNamaByNik(nik));
    		person.setAlamat(personRepository.getAlamatByNik(nik));
    		person.setNik(personRepository.getNikByNik(nik));
    		person.setNoHp(biodataRepository.getNoHpbyNik(nik));
    		person.setTanggalLahir(biodataRepository.getTanggalBynik(nik));
    		person.setTempatLahir(biodataRepository.getTempatByNik(nik));
    		Date date= biodataRepository.getTanggalBynik(nik);
        	Calendar n= Calendar.getInstance();
        	n.setTime(date);
        	int tahunLahir= n.get(Calendar.YEAR);
        	person.setUmur(2020-tahunLahir);
        	person.setJenjangPendidikan(pendRepository.getJenjangTerakhirbyNik(nik));
    	}
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("status","message");
		FilterProvider filters= new SimpleFilterProvider().addFilter("Data Yang Ditampilkan", filter);
		MappingJacksonValue mapp= new MappingJacksonValue(person);
		mapp.setFilters(filters);
		return mapp;
    }
    @GetMapping("/{idPerson}")
    public PersonDto getdtabyid(@PathVariable Integer idPerson) {
    	PersonEntity perent= personRepository.findById(idPerson).get();
    	BiodataEntity bioent= biodataRepository.findById(idPerson).get();
    	PersonDto person= new PersonDto();
    	person.setNoHp(bioent.getNoHp());
    	person.setTanggalLahir(bioent.getTanggalLahir());
    	person.setTempatLahir(bioent.getTempatLahir());
    	person.setNama(bioent.getPersonEntity().getNama());
    	person.setAlamat(bioent.getPersonEntity().getAlamat());
    	person.setNik(bioent.getPersonEntity().getNik());
    	return person;
    			
    }
    @PostMapping
    public MessageDto insert(@RequestBody PersonDto dto) {
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
    		
    	}else if (2020-tahunLahir<30) {
    		return statusGagalUmur();
    	}
    	else {
    		PersonEntity person= convertToEntity(dto);
    		personService.insertPerson(person);
    		dto.setIdPerson(person.getIdPerson());
    		BiodataEntity bio= convertToEntitybio(dto);
    		personService.insertBiodata(bio);
    	}
    	return statusBerhasil();
    }
    
    private MessageDto statusBerhasil() {
    	MessageDto dto= new MessageDto();
    	dto.setStatus("true");
    	dto.setMessage("Data Behasil Masuk");
    	return dto;
    }
    private MessageDto statusGagalNik() {
    	MessageDto dto = new MessageDto();
    	dto.setStatus("false");
    	dto.setMessage("jumlah nik tidak sama dengan 16 digit");
    	return dto;
    }
    private MessageDto statusGagalUmur() {
    	MessageDto dto= new MessageDto();
    	dto.setStatus("false");
    	dto.setMessage("Umur kurang dari 30 tahun");
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
 
  
    public PersonEntity convertToEntity(PersonDto dto){
        PersonEntity personEnt = new PersonEntity();
        personEnt.setNama(dto.getNama());
        personEnt.setNik(dto.getNik());
        personEnt.setAlamat(dto.getAlamat());
        return personEnt;
    }
  
 
  

    private BiodataEntity convertToEntitybio(PersonDto dto){
        BiodataEntity personEnt = new BiodataEntity();
        personEnt.setTanggalLahir(dto.getTanggalLahir());
        personEnt.setTempatLahir(dto.getTempatLahir());
        personEnt.setNoHp(dto.getNoHp());
        PersonEntity person =  personRepository.findById(dto.getIdPerson()).get();
        personEnt.setPersonEntity(person);
        
        return personEnt;
    }

}
