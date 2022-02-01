package com.Store.service;

import java.util.List;

import com.Store.model.ThanhvienDTO;

public interface ThanhVienService {
	public void addThanhVien(ThanhvienDTO thanhVienDTO);

	public void updateThanhVien(ThanhvienDTO thanhVienDTO);

	public void deleteThanhVien(ThanhvienDTO thanhVienDTO);

	public ThanhvienDTO getThanhVienById(int maThanhVien);

	public List<ThanhvienDTO> getAllThanhVien(int currentPage, int size);
	
	public List<ThanhvienDTO> searchThanhVien(String tenThanhVien, String loaiThanhVien,  int currentPage, int size);
	
	public List<String> getRolesByUsername(String username);
	
	public ThanhvienDTO getThanhVienByUsername(String username);
	
	long count();
}
