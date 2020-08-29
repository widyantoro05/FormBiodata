package com.widyantoro.ujianBackend.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_pendidikan")
public class pendidikanEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pendidikan", length = 25, nullable = false)
    private Integer idPendidikan;

	@Column(name = "jenjang", length = 10, nullable = false)
    private String jenjang;
	
	@Column(name = "institusi", length = 50, nullable = false)
    private String institusi;

	@Column(name = "tahun_masuk",length = 10,nullable = false)
    private String tahunMasuk;
	
	@Column(name = "tahun_lulus",length = 10,nullable = false)
    private String tahunLulus;
	
	@ManyToOne
	@JoinColumn(name = "id_person",  nullable = false)
	private personEntity person;

//	set get person_id
	public personEntity getPerson() {
		return person;
	}

	public void setPerson(personEntity person) {
		this.person = person;
	}
// set get pendidikanentity
	
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
