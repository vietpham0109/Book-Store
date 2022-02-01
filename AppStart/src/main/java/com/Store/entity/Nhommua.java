package com.Store.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the NHOMMUA database table.
 * 
 */
@Entity
@Table(name="NHOMMUA")
public class Nhommua implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maNhom;

	private String tenNhom;

	//bi-directional many-to-one association to Sach
	@OneToMany(mappedBy="nhommua")
	private List<Sach> saches;

	public Nhommua() {
	}

	public int getMaNhom() {
		return this.maNhom;
	}

	public void setMaNhom(int maNhom) {
		this.maNhom = maNhom;
	}

	public String getTenNhom() {
		return this.tenNhom;
	}

	public void setTenNhom(String tenNhom) {
		this.tenNhom = tenNhom;
	}

	public List<Sach> getSaches() {
		return this.saches;
	}

	public void setSaches(List<Sach> saches) {
		this.saches = saches;
	}

	public Sach addSach(Sach sach) {
		getSaches().add(sach);
		sach.setNhommua(this);

		return sach;
	}

	public Sach removeSach(Sach sach) {
		getSaches().remove(sach);
		sach.setNhommua(null);

		return sach;
	}

}