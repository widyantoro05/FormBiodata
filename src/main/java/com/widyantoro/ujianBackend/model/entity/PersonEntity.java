package com.widyantoro.ujianBackend.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_person")
public class PersonEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person", length = 25, nullable = false)
    private Integer idPerson;

	@Column(name = "nik",unique=true, length = 16)
    private String nik;
	
	@Column(name = "nama", length = 50)
    private String nama;

	@Column(name = "alamat")
    private String alamat;

	//	id_person
	public Integer getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}
	
//	nik
	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}
	
//	nama
	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}
	
//alamat
    public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}


//    @OneToMany(mappedBy = "province")
//    private List<Kota> kotaList;
//
//    public List<Kota> getKotaList() {
//        return kotaList;
//    }
//
//    public void setKotaList(List<Kota> kotaList) {
//        this.kotaList = kotaList;
//    }

    
}
