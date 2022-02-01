package com.Store.model;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class SachDTO {
	private int maSach;
	private long donGia;
	private String hinhAnh;
	private String hinhAnh2;
	private String hinhAnh3;
	private String moTa;
	private Date ngayCapNhat;
	private int soLuongMua;
	private int soLuongTon;
	private String tenSach;
	private String donGiaS;
	List<MultipartFile> imagefiles;

	private NhommuaDTO nhomMua;
	private TheloaiDTO theLoai;
	private NhaxuatbanDTO nhaXuatBan;
	private String tenTheLoai;

	public int getMaSach() {
		return maSach;
	}

	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}

	public long getDonGia() {
		return donGia;
	}

	public void setDonGia(long donGia) {
		this.donGia = donGia;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getHinhAnh2() {
		return hinhAnh2;
	}

	public void setHinhAnh2(String hinhAnh2) {
		this.hinhAnh2 = hinhAnh2;
	}

	public String getHinhAnh3() {
		return hinhAnh3;
	}

	public void setHinhAnh3(String hinhAnh3) {
		this.hinhAnh3 = hinhAnh3;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Date getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	public int getSoLuongMua() {
		return soLuongMua;
	}

	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public NhommuaDTO getNhomMua() {
		return nhomMua;
	}

	public void setNhomMua(NhommuaDTO nhomMua) {
		this.nhomMua = nhomMua;
	}

	public TheloaiDTO getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(TheloaiDTO theLoai) {
		this.theLoai = theLoai;
	}

	public NhaxuatbanDTO getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(NhaxuatbanDTO nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	
	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

	public String getDonGiaS() {
		return donGiaS;
	}

	public void setDonGiaS(String donGiaS) {
		this.donGiaS = donGiaS;
	}

	public SachDTO(int maSach, long donGia, String hinhAnh, String hinhAnh2, String hinhAnh3, String moTa,
			Date ngayCapNhat, int soLuongMua, int soLuongTon, String tenSach, String tenTheLoai) {
		super();
		this.maSach = maSach;
		this.donGia = donGia;
		this.hinhAnh = hinhAnh;
		this.hinhAnh2 = hinhAnh2;
		this.hinhAnh3 = hinhAnh3;
		this.moTa = moTa;
		this.ngayCapNhat = ngayCapNhat;
		this.soLuongMua = soLuongMua;
		this.soLuongTon = soLuongTon;
		this.tenSach = tenSach;

		this.nhomMua = new NhommuaDTO();
		this.theLoai = new TheloaiDTO();
		this.nhaXuatBan = new NhaxuatbanDTO();
		
		this.tenTheLoai = tenTheLoai;
	}

	public SachDTO() {
		super();

		this.nhomMua = new NhommuaDTO();
		this.theLoai = new TheloaiDTO();
		this.nhaXuatBan = new NhaxuatbanDTO();
	}

	public List<MultipartFile> getImagefiles() {
		return imagefiles;
	}

	public void setImagefiles(List<MultipartFile> imagefiles) {
		this.imagefiles = imagefiles;
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof SachDTO)
				? (((SachDTO) obj).getTheLoai().getMaTheLoai() == this.getTheLoai().getMaTheLoai())
				: false;
	}
	@Override
	public int hashCode() {
		return this.theLoai.getMaTheLoai();
	}

}
