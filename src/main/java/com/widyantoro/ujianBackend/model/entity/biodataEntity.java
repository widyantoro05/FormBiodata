package com.widyantoro.ujianBackend.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="t_biodata")
public class biodataEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bio", length = 25, nullable = false)
    private Integer idBio;

	@Column(name = "nohp", length = 16)
    private String noHp;
	
	@Column(name = "tanggal_lahir", nullable = false)
    private Date tanggalLahir;

	@Column(name = "tempat_lahir",length = 50)
    private String tempatLahir;
	
//	@OneToOne
//	@JoinColumn(name="id_person",nullable = false)
//	private personEntity personEntity;
//	
////set get biodata entity
//	
//	public personEntity getPersonEntity() {
//		return personEntity;
//	}
//
//	public void setPersonEntity(personEntity personEntity) {
//		this.personEntity = personEntity;
//	}

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
