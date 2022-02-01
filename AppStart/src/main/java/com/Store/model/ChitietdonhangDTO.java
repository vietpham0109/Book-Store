package com.Store.model;

public class ChitietdonhangDTO {
	private int maChiTietDDH;
	private long donGia;
	private int soLuong;
	private String tenSach;
	private DonhangDTO donHang;
	private SachDTO sach;
	private String donGiaS;
	
	
	public int getMaChiTietDDH() {
		return maChiTietDDH;
	}
	public void setMaChiTietDDH(int maChiTietDDH) {
		this.maChiTietDDH = maChiTietDDH;
	}
	public long getDonGia() {
		return donGia;
	}
	public void setDonGia(long donGia) {
		this.donGia = donGia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public DonhangDTO getDonHang() {
		return donHang;
	}
	public void setDonHang(DonhangDTO donHang) {
		this.donHang = donHang;
	}
	public SachDTO getSach() {
		return sach;
	}
	public void setSach(SachDTO sach) {
		this.sach = sach;
	}
	
	
	public String getDonGiaS() {
		return donGiaS;
	}
	public void setDonGiaS(String donGiaS) {
		this.donGiaS = donGiaS;
	}
	public ChitietdonhangDTO(int maChiTietDDH, long donGia, int soLuong, String tenSach, String donGiaS) {
		super();
		this.maChiTietDDH = maChiTietDDH;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.tenSach = tenSach;
		this.donGiaS = donGiaS;
		this.donHang = new DonhangDTO();
		this.sach = new SachDTO();
	}
	public ChitietdonhangDTO() {
		super();
		this.donHang = new DonhangDTO();
		this.sach = new SachDTO();
	}
}
