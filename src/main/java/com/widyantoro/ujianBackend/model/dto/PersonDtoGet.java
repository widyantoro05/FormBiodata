package com.widyantoro.ujianBackend.model.dto;

public class PersonDtoGet {
	private Integer idPerson;
	private String nik;
	private String nama;
	private String alamat;
	public Integer getIdPerson() {
		return idPerson;
	}
	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}
	public String getNik() {
		return nik;
	}
	public void setNik(String nik) {
		this.nik = nik;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

}
