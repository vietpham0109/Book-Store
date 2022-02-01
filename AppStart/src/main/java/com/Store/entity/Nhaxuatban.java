package com.Store.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the NHAXUATBAN database table.
 * 
 */
@Entity
@Table(name="NHAXUATBAN")
public class Nhaxuatban implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maNhaXuatBan;

	private String logo;

	private String tenNhaXuatBan;

	private String thongTin;

	//bi-directional many-to-one association to Sach
	@OneToMany(mappedBy="nhaxuatban")
	private List<Sach> saches;

	public Nhaxuatban() {
	}

	public int getMaNhaXuatBan() {
		return this.maNhaXuatBan;
	}

	public void setMaNhaXuatBan(int maNhaXuatBan) {
		this.maNhaXuatBan = maNhaXuatBan;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTenNhaXuatBan() {
		return this.tenNhaXuatBan;
	}

	public void setTenNhaXuatBan(String tenNhaXuatBan) {
		this.tenNhaXuatBan = tenNhaXuatBan;
	}

	public String getThongTin() {
		return this.thongTin;
	}

	public void setThongTin(String thongTin) {
		this.thongTin = thongTin;
	}

	public List<Sach> getSaches() {
		return this.saches;
	}

	public void setSaches(List<Sach> saches) {
		this.saches = saches;
	}

	public Sach addSach(Sach sach) {
		getSaches().add(sach);
		sach.setNhaxuatban(this);

		return sach;
	}

	public Sach removeSach(Sach sach) {
		getSaches().remove(sach);
		sach.setNhaxuatban(null);

		return sach;
	}

}