package com.Store.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PHANHOI database table.
 * 
 */
@Entity
@Table(name="PHANHOI")
public class Phanhoi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maPhanHoi;

	private String noiDung;

	//bi-directional many-to-one association to Sach
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maSach")
	private Sach sach;

	//bi-directional many-to-one association to Thanhvien
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maThanhVien")
	private Thanhvien thanhvien;

	public Phanhoi() {
	}

	public int getMaPhanHoi() {
		return this.maPhanHoi;
	}

	public void setMaPhanHoi(int maPhanHoi) {
		this.maPhanHoi = maPhanHoi;
	}

	public String getNoiDung() {
		return this.noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Sach getSach() {
		return this.sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	public Thanhvien getThanhvien() {
		return this.thanhvien;
	}

	public void setThanhvien(Thanhvien thanhvien) {
		this.thanhvien = thanhvien;
	}

}