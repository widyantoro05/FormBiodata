package com.widyantoro.ujianBackend.model.dto;

public class PendidikanDto {
	private Integer idPendidikan;
	private String jenjang;
	private String institusi;
	private String tahunMasuk;
	private String tahunLulus;

	
//	set get pendidikan dto
	
	public Integer getIdPendidikan() {
		return idPendidikan;
	}
	public void setIdPendidikan(Integer idPendidikan) {
		this.idPendidikan = idPendidikan;
	}
	public String getJenjang() {
		return jenjang;
	}
	public void setJenjang(String jenjang) {
		this.jenjang = jenjang;
	}
	public String getInstitusi() {
		return institusi;
	}
	public void setInstitusi(String institusi) {
		this.institusi = institusi;
	}
	public String getTahunMasuk() {
		return tahunMasuk;
	}
	public void setTahunMasuk(String tahunMasuk) {
		this.tahunMasuk = tahunMasuk;
	}
	public String getTahunLulus() {
		return tahunLulus;
	}
	public void setTahunLulus(String tahunLulus) {
		this.tahunLulus = tahunLulus;
	}
}
