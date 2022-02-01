package com.Store.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the SACH database table.
 * 
 */
@Entity
@Table(name="SACH")
public class Sach implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="maSach")
	private int maSach;

	private long donGia;

	private String hinhAnh;

	private String hinhAnh2;

	private String hinhAnh3;
	
	private String moTa;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ngayCapNhat;

	private int soLuongMua;

	private int soLuongTon;

	private String tenSach;

	//bi-directional many-to-one association to ChiTietDonHang
	@OneToMany(mappedBy="sach")
	private List<Chitietdonhang> chitietdonhangs;

	//bi-directional many-to-one association to Phanhoi
	@OneToMany(mappedBy="sach")
	private List<Phanhoi> phanhois;

	//bi-directional many-to-one association to Nhaxuatban
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maNhaXuatBan")
	private Nhaxuatban nhaxuatban;

	//bi-directional many-to-one association to Nhommua
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maNhom")
	private Nhommua nhommua;

	//bi-directional many-to-one association to Theloai
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maTheLoai")
	private Theloai theloai;

	public Sach() {
	}

	public int getMaSach() {
		return this.maSach;
	}

	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}

	public long getDonGia() {
		return this.donGia;
	}

	public void setDonGia(long donGia) {
		this.donGia = donGia;
	}

	public String getHinhAnh() {
		return this.hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getHinhAnh2() {
		return this.hinhAnh2;
	}

	public void setHinhAnh2(String hinhAnh2) {
		this.hinhAnh2 = hinhAnh2;
	}

	public String getHinhAnh3() {
		return this.hinhAnh3;
	}

	public void setHinhAnh3(String hinhAnh3) {
		this.hinhAnh3 = hinhAnh3;
	}

	public String getMoTa() {
		return this.moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Date getNgayCapNhat() {
		return this.ngayCapNhat;
	}

	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	public int getSoLuongMua() {
		return this.soLuongMua;
	}

	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}

	public int getSoLuongTon() {
		return this.soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public String getTenSach() {
		return this.tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public List<Chitietdonhang> getChiTietDonHangs() {
		return this.chitietdonhangs;
	}

	public void setChiTietDonHangs(List<Chitietdonhang> chitietdonhangs) {
		this.chitietdonhangs = chitietdonhangs;
	}

	public Chitietdonhang addChiTietDonHang(Chitietdonhang chiTietDonHang) {
		getChiTietDonHangs().add(chiTietDonHang);
		chiTietDonHang.setSach(this);

		return chiTietDonHang;
	}

	public Chitietdonhang removeChiTietDonHang(Chitietdonhang chiTietDonHang) {
		getChiTietDonHangs().remove(chiTietDonHang);
		chiTietDonHang.setSach(null);

		return chiTietDonHang;
	}

	public List<Phanhoi> getPhanhois() {
		return this.phanhois;
	}

	public void setPhanhois(List<Phanhoi> phanhois) {
		this.phanhois = phanhois;
	}

	public Phanhoi addPhanhoi(Phanhoi phanhoi) {
		getPhanhois().add(phanhoi);
		phanhoi.setSach(this);

		return phanhoi;
	}

	public Phanhoi removePhanhoi(Phanhoi phanhoi) {
		getPhanhois().remove(phanhoi);
		phanhoi.setSach(null);

		return phanhoi;
	}

	public Nhaxuatban getNhaxuatban() {
		return this.nhaxuatban;
	}

	public void setNhaxuatban(Nhaxuatban nhaxuatban) {
		this.nhaxuatban = nhaxuatban;
	}

	public Nhommua getNhommua() {
		return this.nhommua;
	}

	public void setNhommua(Nhommua nhommua) {
		this.nhommua = nhommua;
	}

	public Theloai getTheloai() {
		return this.theloai;
	}

	public void setTheloai(Theloai theloai) {
		this.theloai = theloai;
	}

}