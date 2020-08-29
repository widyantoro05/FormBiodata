package com.widyantoro.ujianBackend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.widyantoro.ujianBackend.model.dto.biodataDto;
import com.widyantoro.ujianBackend.model.entity.biodataEntity;
import com.widyantoro.ujianBackend.model.entity.personEntity;
import com.widyantoro.ujianBackend.repository.biodataRepository;
import com.widyantoro.ujianBackend.repository.personRepository;

@RestController
@RequestMapping("/biodata")
public class biodataController {
	private final biodataRepository biorepository;
    private final personRepository persRepository;

    @Autowired
    public biodataController(biodataRepository biorepository, personRepository persRepository) {
        this.biorepository = biorepository;
        this.persRepository = persRepository;
    }


    // http://localhost:8080/kota
    @GetMapping
    public List<biodataDto> get() {
        List<biodataEntity> biodataList = biorepository.findAll();
        List<biodataDto> biodataDtoList = biodataList.stream().map(this::convertToDto)
                .collect(Collectors.toList());
        return biodataDtoList;
    }

    // http://localhost:8080/kota/3303
    @GetMapping("/{id_biodata}")
    public biodataDto getIdBio(@PathVariable Integer idBio) {
        if(biorepository.findById(idBio).isPresent()){
            biodataDto biodataDto =  convertToDto(biorepository.findById(idBio).get());
            return biodataDto;
        }
        return null;
    }

//    @GetMapping("/pers/{id_person}")
//    public List<biodataDto> getIdperson(@PathVariable Integer idPerson) {
////        if(repository.findById(code).isPresent()){
////            KotaDto kotaDto =  convertToDto(repository.findById(code).get());
////            return kotaDto;
////        }
//        List<biodataEntity> biodataList = biorepository.findAllbyIdPerson(idPerson);
//        List<biodataDto> biodataDtoList = biodataList.stream().map(this::convertToDto)
//                .collect(Collectors.toList());
//        return biodataDtoList;
//    }
    /*Insert Data*/
    @PostMapping
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    public biodataDto insert(@RequestBody biodataDto dto) {
        biodataEntity biodata = convertToEntity(dto);
        biorepository.save(biodata);
        return dto;
    }

    private biodataEntity convertToEntity(biodataDto dto){
        biodataEntity biodata = new biodataEntity();
        biodata.setIdBio(dto.getIdBio());
        biodata.setNoHp(dto.getNoHp());
        biodata.setTanggalLahir(dto.getTanggalLahir());
        biodata.setTempatLahir(dto.getTempatLahir());

        return biodata;
    }

    private biodataDto convertToDto(biodataEntity bio){
        biodataDto bioDto = new biodataDto();
        bioDto.setIdBio(bio.getIdBio());
        bioDto.setNoHp(bio.getNoHp());
        bioDto.setTanggalLahir(bio.getTanggalLahir());
        bioDto.setTempatLahir(bio.getTempatLahir());
        return bioDto;
    }
}
