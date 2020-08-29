package com.widyantoro.ujianBackend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.widyantoro.ujianBackend.model.dto.personDto;
import com.widyantoro.ujianBackend.model.entity.biodataEntity;
import com.widyantoro.ujianBackend.model.entity.personEntity;
import com.widyantoro.ujianBackend.repository.biodataRepository;
import com.widyantoro.ujianBackend.repository.personRepository;


@RestController
@RequestMapping("/person")
public class personController {
	private final personRepository personRepository;
	private final biodataRepository biodataRepository;

    @Autowired
    public personController(personRepository personRepository, biodataRepository bio) {
        this.personRepository = personRepository;
        this.biodataRepository=bio;
    }

    // http://localhost:1212/person
    @GetMapping
    public List<personDto> get() {
        List<personEntity> personList = personRepository.findAll();
        List<personDto> personDtoList = personList.stream().map(this::convertToDto)
                .collect(Collectors.toList());
        return personDtoList;
    }
    
//    get by nik
    @GetMapping("/{nik}")
    public List<personDto> getNik(@PathVariable String nik) {
        List<personEntity> personList = personRepository.findByNik(nik);
        List<personDto> personDtoList = personList.stream().map(this::convertToDto)
                .collect(Collectors.toList());
        return personDtoList;
    }

  
//   post mapping
    /*Insert Data*/
    @PostMapping
    public personDto insert(@RequestBody personDto dto) {
        personEntity persEntity = convertToEntity(dto);
        biodataEntity bio= convertToEntitybio(dto);
        personRepository.save(persEntity);
        biodataRepository.save(bio);
        return dto;
    }
//    public personDto insertbio(@RequestBody personDto dto) {
//        biodataEntity persEntity = convertToEntitybio(dto);
//        biodataRepository.save(persEntity);
//        return dto;
//    }
 
  
    private personEntity convertToEntity(personDto dto){
        personEntity personEnt = new personEntity();
        personEnt.setIdPerson(dto.getIdPerson());
        personEnt.setNama(dto.getNama());
        personEnt.setNik(dto.getNik());
        personEnt.setAlamat(dto.getAlamat());
        return personEnt;
    }
  
 
    private personDto convertToDto(personEntity person){
        personDto personDto = new personDto();
        personDto.setIdPerson(person.getIdPerson());
        personDto.setNama(person.getNama());
        personDto.setNik(person.getNik());
        personDto.setAlamat(person.getAlamat());
//        personDto.setTanggalLahir(bio.getTanggalLahir());
//        personDto.setTempatLahir(bio.getTempatLahir());
//        personDto.setNoHp(bio.getNoHp());
        return personDto;
    }

    private biodataEntity convertToEntitybio(personDto dto){
        biodataEntity personEnt = new biodataEntity();
        personEnt.setTanggalLahir(dto.getTanggalLahir());
        personEnt.setTempatLahir(dto.getTempatLahir());
        personEnt.setNoHp(dto.getNoHp());
//            personEntity province =  personRepository.findById(dto.getIdPerson()).get();
//            personEnt.setPersonEntity(province);
        
        return personEnt;
    }

}
