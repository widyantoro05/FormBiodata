package com.widyantoro.ujianBackend.model.dto;

import java.sql.Date;

public class biodataDto {
	private Integer idBio;
	private Integer idPerson;
	private String noHp;
	private Date tanggalLahir;
	private String tempatLahir;
	
	
//	set get person
	public Integer getIdPerson() {
		return idPerson;
	}
	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}
	
//	set get biodata
	
	public Integer getIdBio() {
		return idBio;
	}
	public void setIdBio(Integer idBio) {
		this.idBio = idBio;
	}
	public String getNoHp() {
		return noHp;
	}
	public void setNoHp(String noHp) {
		this.noHp = noHp;
	}
	public Date getTanggalLahir() {
		return tanggalLahir;
	}
	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}
	public String getTempatLahir() {
		return tempatLahir;
	}
	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}
}
