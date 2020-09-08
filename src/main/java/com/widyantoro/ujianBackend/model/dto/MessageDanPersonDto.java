package com.widyantoro.ujianBackend.model.dto;

import java.sql.Date;

public class MessageDanPersonDto {
	private String nik;
	private String nama;
	private String alamat;
	private Date tanggalLahir;
	private String tempatLahir;
	private String noHp;
	private Integer umur;
	private String jenjangPendidikan;
	private String message;
	private String status;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getUmur() {
		return umur;
	}
	public void setUmur(Integer umur) {
		this.umur = umur;
	}
	public String getJenjangPendidikan() {
		return jenjangPendidikan;
	}
	public void setJenjangPendidikan(String jenjangPendidikan) {
		this.jenjangPendidikan = jenjangPendidikan;
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
	public String getNoHp() {
		return noHp;
	}
	public void setNoHp(String noHp) {
		this.noHp = noHp;
	}
}
