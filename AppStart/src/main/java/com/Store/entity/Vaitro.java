package com.Store.entity;

import javax.persistence.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "VAITRO")
public class Vaitro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maVaiTro;

	private String tenVaiTro;

	// bi-directional many-to-many association to Loaithanhvien
	@ManyToMany
	@JoinTable(name = "VAITRO_LOAITHANHVIEN", joinColumns = { @JoinColumn(name = "maVaiTro") }, inverseJoinColumns = {
			@JoinColumn(name = "maLoaiThanhVien") })
	private List<Loaithanhvien> loaithanhviens;

	public Vaitro() {
	}

	public int getMaVaiTro() {
		return this.maVaiTro;
	}

	public void setMaVaiTro(int maVaiTro) {
		this.maVaiTro = maVaiTro;
	}

	public String getTenVaiTro() {
		return this.tenVaiTro;
	}

	public void setTenVaiTro(String tenVaiTro) {
		this.tenVaiTro = tenVaiTro;
	}

	public List<Loaithanhvien> getLoaithanhviens() {
		return this.loaithanhviens;
	}

	public void setLoaithanhviens(List<Loaithanhvien> loaithanhviens) {
		this.loaithanhviens = loaithanhviens;
	}
}
