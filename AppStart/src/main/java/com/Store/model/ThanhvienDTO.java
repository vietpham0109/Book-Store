package com.Store.model;

public class ThanhvienDTO {
	private int maThanhVien;
	private String diaChi;
	private String email;
	private String hoTen;
	private String matKhau;
	private String soDienThoai;
	private String taiKhoan;
	
	private LoaithanhvienDTO loaiThanhVien;

	public int getMaThanhVien() {
		return maThanhVien;
	}

	public void setMaThanhVien(int maThanhVien) {
		this.maThanhVien = maThanhVien;
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

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public LoaithanhvienDTO getLoaiThanhVien() {
		return loaiThanhVien;
	}

	public void setLoaiThanhVien(LoaithanhvienDTO loaiThanhVien) {
		this.loaiThanhVien = loaiThanhVien;
	}

	public ThanhvienDTO() {
		super();
		this.loaiThanhVien = new LoaithanhvienDTO();
		// TODO Auto-generated constructor stub
	}

	public ThanhvienDTO(int maThanhVien, String diaChi, String email, String hoTen, String matKhau, String soDienThoai,
			String taiKhoan, LoaithanhvienDTO loaiThanhVien) {
		super();
		this.maThanhVien = maThanhVien;
		this.diaChi = diaChi;
		this.email = email;
		this.hoTen = hoTen;
		this.matKhau = matKhau;
		this.soDienThoai = soDienThoai;
		this.taiKhoan = taiKhoan;
		this.loaiThanhVien = new LoaithanhvienDTO();
	}
	
	
	
}
