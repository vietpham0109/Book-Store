package com.Store.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the THANHVIEN database table.
 * 
 */
@Entity
@Table(name="THANHVIEN")
public class Thanhvien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maThanhVien;

	private String diaChi;

	private String email;

	private String hoTen;

	private String matKhau;

	private String soDienThoai;

	private String taiKhoan;

	//bi-directional many-to-one association to Khachhang
	@OneToMany(mappedBy="thanhvien")
	private List<Khachhang> khachhangs;

	//bi-directional many-to-one association to Phanhoi
	@OneToMany(mappedBy="thanhvien")
	private List<Phanhoi> phanhois;

	//bi-directional many-to-one association to Loaithanhvien
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maLoaiThanhVien")
	private Loaithanhvien loaithanhvien;

	public Thanhvien() {
	}

	public int getMaThanhVien() {
		return this.maThanhVien;
	}

	public void setMaThanhVien(int maThanhVien) {
		this.maThanhVien = maThanhVien;
	}

	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getMatKhau() {
		return this.matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getSoDienThoai() {
		return this.soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTaiKhoan() {
		return this.taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public List<Khachhang> getKhachhangs() {
		return this.khachhangs;
	}

	public void setKhachhangs(List<Khachhang> khachhangs) {
		this.khachhangs = khachhangs;
	}

	public Khachhang addKhachhang(Khachhang khachhang) {
		getKhachhangs().add(khachhang);
		khachhang.setThanhvien(this);

		return khachhang;
	}

	public Khachhang removeKhachhang(Khachhang khachhang) {
		getKhachhangs().remove(khachhang);
		khachhang.setThanhvien(null);

		return khachhang;
	}

	public List<Phanhoi> getPhanhois() {
		return this.phanhois;
	}

	public void setPhanhois(List<Phanhoi> phanhois) {
		this.phanhois = phanhois;
	}

	public Phanhoi addPhanhoi(Phanhoi phanhoi) {
		getPhanhois().add(phanhoi);
		phanhoi.setThanhvien(this);

		return phanhoi;
	}

	public Phanhoi removePhanhoi(Phanhoi phanhoi) {
		getPhanhois().remove(phanhoi);
		phanhoi.setThanhvien(null);

		return phanhoi;
	}

	public Loaithanhvien getLoaithanhvien() {
		return this.loaithanhvien;
	}

	public void setLoaithanhvien(Loaithanhvien loaithanhvien) {
		this.loaithanhvien = loaithanhvien;
	}

}