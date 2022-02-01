package com.Store.model;

import java.util.ArrayList;
import java.util.List;

public class LoaithanhvienDTO {
	private int maLoaiThanhVien;
	private String tenLoaiThanhVien;
	private int uuDai;
	private List<VaitroDTO> vaiTro;
	
	public int getMaLoaiThanhVien() {
		return maLoaiThanhVien;
	}

	public void setMaLoaiThanhVien(int maLoaiThanhVien) {
		this.maLoaiThanhVien = maLoaiThanhVien;
	}
	
	public String getTenLoaiThanhVien() {
		return tenLoaiThanhVien;
	}

	public void setTenLoaiThanhVien(String tenLoaiThanhVien) {
		this.tenLoaiThanhVien = tenLoaiThanhVien;
	}

	public int getUuDai() {
		return uuDai;
	}

	public void setUuDai(int uuDai) {
		this.uuDai = uuDai;
	}

	public List<VaitroDTO> getVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(List<VaitroDTO> vaiTro) {
		this.vaiTro = vaiTro;
	}
	
	public LoaithanhvienDTO() {
		super();
		this.vaiTro = new ArrayList<VaitroDTO>();
	}

	public LoaithanhvienDTO(int maLoaiThanhVien, String tenLoaiThanhVien, int uuDai) {
		super();
		this.maLoaiThanhVien = maLoaiThanhVien;
		this.tenLoaiThanhVien = tenLoaiThanhVien;
		this.uuDai = uuDai;
		this.vaiTro = new ArrayList<VaitroDTO>();
	}
	
	
}
