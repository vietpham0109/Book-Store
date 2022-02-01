package com.Store.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LOAITHANHVIEN database table.
 * 
 */
@Entity
@Table(name="LOAITHANHVIEN")
public class Loaithanhvien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maLoaiThanhVien;

	private String tenLoaiThanhVien;

	private int uuDai;

	//bi-directional many-to-one association to Thanhvien
	@OneToMany(mappedBy="loaithanhvien")
	private List<Thanhvien> thanhviens;
	
	//bi-directional many-to-many association to Vaitro
	@ManyToMany(mappedBy="loaithanhviens")
	private List<Vaitro> vaitros;

	public Loaithanhvien() {
	}

	public int getMaLoaiThanhVien() {
		return this.maLoaiThanhVien;
	}

	public void setMaLoaiThanhVien(int maLoaiThanhVien) {
		this.maLoaiThanhVien = maLoaiThanhVien;
	}

	public String getTenLoaiThanhVien() {
		return this.tenLoaiThanhVien;
	}

	public void setTenLoaiThanhVien(String tenLoaiThanhVien) {
		this.tenLoaiThanhVien = tenLoaiThanhVien;
	}

	public int getUuDai() {
		return this.uuDai;
	}

	public void setUuDai(int uuDai) {
		this.uuDai = uuDai;
	}

	public List<Thanhvien> getThanhviens() {
		return this.thanhviens;
	}

	public void setThanhviens(List<Thanhvien> thanhviens) {
		this.thanhviens = thanhviens;
	}

	public Thanhvien addThanhvien(Thanhvien thanhvien) {
		getThanhviens().add(thanhvien);
		thanhvien.setLoaithanhvien(this);

		return thanhvien;
	}

	public Thanhvien removeThanhvien(Thanhvien thanhvien) {
		getThanhviens().remove(thanhvien);
		thanhvien.setLoaithanhvien(null);

		return thanhvien;
	}

	public List<Vaitro> getVaitros() {
		return this.vaitros;
	}

	public void setVaitros(List<Vaitro> vaitros) {
		this.vaitros = vaitros;
	}
}