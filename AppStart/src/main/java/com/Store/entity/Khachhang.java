package com.Store.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the KHACHHANG database table.
 * 
 */
@Entity
@Table(name="KHACHHANG")
public class Khachhang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maKhachHang;

	private String diaChi;

	private String email;

	private String soDienThoai;

	private String tenKhachHang;

	//bi-directional many-to-one association to Donhang
	@OneToMany(mappedBy="khachhang")
	private List<Donhang> donhangs;

	//bi-directional many-to-one association to Thanhvien
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maThanhVien")
	private Thanhvien thanhvien;

	public Khachhang() {
	}

	public int getMaKhachHang() {
		return this.maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
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

	public String getSoDienThoai() {
		return this.soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTenKhachHang() {
		return this.tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public List<Donhang> getDonhangs() {
		return this.donhangs;
	}

	public void setDonhangs(List<Donhang> donhangs) {
		this.donhangs = donhangs;
	}

	public Donhang addDonhang(Donhang donhang) {
		getDonhangs().add(donhang);
		donhang.setKhachhang(this);

		return donhang;
	}

	public Donhang removeDonhang(Donhang donhang) {
		getDonhangs().remove(donhang);
		donhang.setKhachhang(null);

		return donhang;
	}

	public Thanhvien getThanhvien() {
		return this.thanhvien;
	}

	public void setThanhvien(Thanhvien thanhvien) {
		this.thanhvien = thanhvien;
	}

}