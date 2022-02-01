package com.Store.model;

public class NhaxuatbanDTO {
	private int maNhaXuatBan;
	private String logo;
	private String tenNhaXuatBan;
	private String thongTin;

	public int getMaNhaXuatBan() {
		return maNhaXuatBan;
	}

	public void setMaNhaXuatBan(int maNhaXuatBan) {
		this.maNhaXuatBan = maNhaXuatBan;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTenNhaXuatBan() {
		return tenNhaXuatBan;
	}

	public void setTenNhaXuatBan(String tenNhaXuatBan) {
		this.tenNhaXuatBan = tenNhaXuatBan;
	}

	public String getThongTin() {
		return thongTin;
	}

	public void setThongTin(String thongTin) {
		this.thongTin = thongTin;
	}

	public NhaxuatbanDTO(int maNhaXuatBan, String logo, String tenNhaXuatBan, String thongTin) {
		super();
		this.maNhaXuatBan = maNhaXuatBan;
		this.logo = logo;
		this.tenNhaXuatBan = tenNhaXuatBan;
		this.thongTin = thongTin;
	}

	public NhaxuatbanDTO() {
		super();
	}
	
	
}
