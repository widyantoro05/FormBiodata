package com.widyantoro.ujianBackend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.widyantoro.ujianBackend.model.dto.MessageDto;
import com.widyantoro.ujianBackend.model.dto.PendidikanDto;
import com.widyantoro.ujianBackend.model.entity.PendidikanEntity;
import com.widyantoro.ujianBackend.model.entity.PersonEntity;
import com.widyantoro.ujianBackend.repository.PendidikanRepository;
import com.widyantoro.ujianBackend.repository.PersonRepository;
import com.widyantoro.ujianBackend.service.PersonService;

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
    @Autowired
    private PersonService personService;
    
    // http://localhost:8080/kecamatan
    @PostMapping("/{idperson}")
    public MessageDto insert(@RequestBody List<PendidikanDto> list, @PathVariable Integer idperson) {
	    try {
	    	for (PendidikanDto p: list) {
		    	 PendidikanEntity pend= convertToEntity(p);
		    	 if (persRepository.findById(idperson).isPresent()) {
		    		 PersonEntity person = persRepository.findById(idperson).get();
		    		 pend.setPerson(person);
		    	 }
		    	 personService.insertPendidikan(pend);
		     }
	    }catch (Exception e){
	    	return statusGagal();
	    }
    	
        return statusBerhasil();
    }
    
    private MessageDto statusGagal() {
    	MessageDto dto= new MessageDto();
    	dto.setMessage("Data tidak berhasil masuk");
    	dto.setStatus("false");
    	return dto;
    }
    private MessageDto statusBerhasil() {
    	MessageDto dto= new MessageDto();
    	dto.setMessage("Data berhasil masuk");
    	dto.setStatus("true");
    	return dto;
    }
    private PendidikanEntity convertToEntity(PendidikanDto dto){
        PendidikanEntity pendidikan = new PendidikanEntity();
        pendidikan.setInstitusi(dto.getInstitusi());
        pendidikan.setJenjang(dto.getJenjang());
        pendidikan.setTahunLulus(dto.getTahunLulus());
        pendidikan.setTahunMasuk(dto.getTahunMasuk());
        return pendidikan;
    }

//    // http://localhost:8080/kecamatan/3303
//    @GetMapping("/{id_pendidikan}")
//    public PendidikanDto get(@PathVariable Integer id) {
//        if(pendRepository.findById(id).isPresent()){
//            PendidikanDto pendDto =  convertToDto(pendRepository.findById(id).get());
//            return pendDto;
//        }
//        return null;
//    }

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
//    @PostMapping
//    public MessageDto insert(@RequestBody List<PendidikanDto> Listpend ) {
//    	int error=0;
//    	for (int i=0;i<Listpend.size();i++) {
//        	PendidikanEntity pendidikan = convertToEntity(Listpend.get(i));
//            pendRepository.save(pendidikan);
//        }
//    	
//    }

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

   

//    private PendidikanDto convertToDto(PendidikanEntity pend){
//        PendidikanDto dto = new PendidikanDto();
//        dto.setIdPendidikan(pend.getIdPendidikan());
//        dto.setInstitusi(pend.getInstitusi());
//        dto.setJenjang(pend.getJenjang());
//        dto.setTahunLulus(pend.getJenjang());
//        dto.setTahunMasuk(pend.getTahunMasuk());
//        dto.setIdPerson(pend.getPerson().getIdPerson());
//        return dto;
//    }
}
