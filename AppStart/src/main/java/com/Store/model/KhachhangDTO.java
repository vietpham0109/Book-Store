package com.Store.model;

import java.util.ArrayList;
import java.util.List;

public class KhachhangDTO {
	private int maKhachHang;
	private String diaChi;
	private String email;
	private String soDienThoai;
	private String tenKhachHang;
	private List<DonhangDTO> donHang;
	private ThanhvienDTO thanhVien;
	public int getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public List<DonhangDTO> getDonHang() {
		return donHang;
	}
	public void setDonHang(List<DonhangDTO> donHang) {
		this.donHang = donHang;
	}
	public ThanhvienDTO getThanhVien() {
		return thanhVien;
	}
	public void setThanhVien(ThanhvienDTO thanhVien) {
		this.thanhVien = thanhVien;
	}
	public KhachhangDTO() {
		super();
		this.donHang = new ArrayList<DonhangDTO>();
		this.thanhVien = new ThanhvienDTO();
	}
	public KhachhangDTO(int maKhachHang, String diaChi, String email, String soDienThoai, String tenKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
		this.diaChi = diaChi;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.tenKhachHang = tenKhachHang;
		this.donHang = new ArrayList<DonhangDTO>();
		this.thanhVien = new ThanhvienDTO();
	}
	
	
	
}
