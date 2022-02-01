package com.Store.model;

import java.util.ArrayList;
import java.util.List;

public class VaitroDTO {
	private int maVaiTro;
	private String tenVaiTro;
	private List<LoaithanhvienDTO> loaiThanhVien;
	
	public int getMaVaiTro() {
		return maVaiTro;
	}
	public void setMaVaiTro(int maVaiTro) {
		this.maVaiTro = maVaiTro;
	}
	public String getTenVaiTro() {
		return tenVaiTro;
	}
	public void setTenVaiTro(String tenVaiTro) {
		this.tenVaiTro = tenVaiTro;
	}
	public List<LoaithanhvienDTO> getLoaiThanhVien() {
		return loaiThanhVien;
	}
	public void setLoaiThanhVien(List<LoaithanhvienDTO> loaiThanhVien) {
		this.loaiThanhVien = loaiThanhVien;
	}
	public VaitroDTO() {
		super();
		this.loaiThanhVien = new ArrayList<LoaithanhvienDTO>();
	}
	public VaitroDTO(int maVaiTro, String tenVaiTro) {
		super();
		this.maVaiTro = maVaiTro;
		this.tenVaiTro = tenVaiTro;
		this.loaiThanhVien = new ArrayList<LoaithanhvienDTO>();
	}
	
}
