package com.Store.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DONHANG database table.
 * 
 */
@Entity
@Table(name="DONHANG")
public class Donhang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maDonHang;

	private boolean daThanhToan;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ngayDat;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ngayGiao;

	private String tinhTrangGiaoHang;

	private int uuDai;

	//bi-directional many-to-one association to ChiTietDonHang
	@OneToMany(mappedBy="donhang")
	private List<Chitietdonhang> chitietdonhangs;

	//bi-directional many-to-one association to Khachhang
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="maKhachHang")
	private Khachhang khachhang;

	public Donhang() {
	}

	public int getMaDonHang() {
		return this.maDonHang;
	}

	public void setMaDonHang(int maDonHang) {
		this.maDonHang = maDonHang;
	}

	public boolean getDaThanhToan() {
		return this.daThanhToan;
	}

	public void setDaThanhToan(boolean daThanhToan) {
		this.daThanhToan = daThanhToan;
	}

	public Date getNgayDat() {
		return this.ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public Date getNgayGiao() {
		return this.ngayGiao;
	}

	public void setNgayGiao(Date ngayGiao) {
		this.ngayGiao = ngayGiao;
	}

	public String getTinhTrangGiaoHang() {
		return this.tinhTrangGiaoHang;
	}

	public void setTinhTrangGiaoHang(String tinhTrangGiaoHang) {
		this.tinhTrangGiaoHang = tinhTrangGiaoHang;
	}

	public int getUuDai() {
		return this.uuDai;
	}

	public void setUuDai(int uuDai) {
		this.uuDai = uuDai;
	}

	public List<Chitietdonhang> getChiTietDonHangs() {
		return this.chitietdonhangs;
	}

	public void setChiTietDonHangs(List<Chitietdonhang> chitietdonhangs) {
		this.chitietdonhangs = chitietdonhangs;
	}

	public Chitietdonhang addChiTietDonHang(Chitietdonhang chiTietDonHang) {
		getChiTietDonHangs().add(chiTietDonHang);
		chiTietDonHang.setDonhang(this);

		return chiTietDonHang;
	}

	public Chitietdonhang removeChiTietDonHang(Chitietdonhang chiTietDonHang) {
		getChiTietDonHangs().remove(chiTietDonHang);
		chiTietDonHang.setDonhang(null);

		return chiTietDonHang;
	}

	public Khachhang getKhachhang() {
		return this.khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

}