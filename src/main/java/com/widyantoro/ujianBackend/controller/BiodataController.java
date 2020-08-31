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

import com.widyantoro.ujianBackend.model.dto.PendidikanDto;
import com.widyantoro.ujianBackend.model.entity.PendidikanEntity;
import com.widyantoro.ujianBackend.model.entity.PersonEntity;
import com.widyantoro.ujianBackend.repository.PendidikanRepository;
import com.widyantoro.ujianBackend.repository.PersonRepository;

@RestController
@RequestMapping("/pendidikan")
public class BiodataController {
	private final PendidikanRepository pendRepository;
    private final PersonRepository persRepository;

    @Autowired
    public BiodataController(PendidikanRepository pendRepository, PersonRepository persRepository) {
        this.pendRepository = pendRepository;
        this.persRepository = persRepository;
    }


    // http://localhost:8080/kecamatan
    @GetMapping
    public List<PendidikanDto> get() {
        List<PendidikanEntity> pendList = pendRepository.findAll();
        List<PendidikanDto> pendDtoList = pendList.stream().map(this::convertToDto)
                .collect(Collectors.toList());
        return pendDtoList;
    }

    // http://localhost:8080/kecamatan/3303
    @GetMapping("/{id_pendidikan}")
    public PendidikanDto get(@PathVariable Integer id) {
        if(pendRepository.findById(id).isPresent()){
            PendidikanDto pendDto =  convertToDto(pendRepository.findById(id).get());
            return pendDto;
        }
        return null;
    }

//    @GetMapping("/{id_person}")
//    public List<pendidikanDto> getByPerson(@PathVariable Integer idPerson) {
////        List<Kecamatan> kecamatanList = kecamatanRepository.findAllByProveKodeProvince(4);
//        List<pendidikanEntity> pendList = pendRepository.findAllByIdperson(idPerson);
////        Province province = provinceRepository.findById(codeProvince).get();
////        List<Kecamatan> kecamatanList = kecamatanRepository.findAllByProve(province);
//        List<pendidikanDto> pendDtoList = pendList.stream().map(this::convertToDto)
//                .collect(Collectors.toList());
//        return pendDtoList;
//    }
    /*Insert Data*/
    @PostMapping
    public PendidikanDto insert(@RequestBody PendidikanDto dto) {
        PendidikanEntity pendidikan = convertToEntity(dto);
        pendRepository.save(pendidikan);
        return convertToDto(pendidikan);
    }

    /*Insert Data*/
//    @PostMapping("/trx")
//    public pendidikanDto insertTrx(@RequestBody pendidikanDto dto) {
//        pendidikanEntity pendidikan = convertToEntity(dto);
//        kecamatanService.insertDataKecamatan(pendidikan);
//        return convertToDto(pendidikan);
//    }

    /*Insert Data*/
//    @PostMapping("/notrx")
//    public pendidikanDto insertNoTrx(@RequestBody pendidikanDto dto) {
//        pendidikanEntity pend = convertToEntity(dto);
//        pendidikanEntity entity = pendRepository.save(pend);
//        entity.setJumlahPendudukKecamatan(4000);
//        pendRepository.save(entity);
//        return convertToDto(pend);
//    }

    private PendidikanEntity convertToEntity(PendidikanDto dto){
        PendidikanEntity pendidikan = new PendidikanEntity();
        pendidikan.setIdPendidikan(dto.getIdPendidikan());
        pendidikan.setInstitusi(dto.getInstitusi());
        pendidikan.setJenjang(dto.getJenjang());
        pendidikan.setTahunLulus(dto.getTahunLulus());
        pendidikan.setTahunMasuk(dto.getTahunMasuk());

//        if(persRepository.findById(dto.getIdPerson()).isPresent()){
//            personEntity person =  persRepository.findById(dto.getIdPerson()).get();
//            pendidikan.setPerson(person);
//        }
        return pendidikan;
    }

    private PendidikanDto convertToDto(PendidikanEntity pend){
        PendidikanDto dto = new PendidikanDto();
        dto.setIdPendidikan(pend.getIdPendidikan());
        dto.setInstitusi(pend.getInstitusi());
        dto.setJenjang(pend.getJenjang());
        dto.setTahunLulus(pend.getJenjang());
//        dto.setTahunMasuk(pend.getTahunMasuk());
//        dto.setIdPerson(pend.getPerson().getIdPerson());
        return dto;
    }
}
