package com.Store.service;

import java.util.List;

import com.Store.model.LoaithanhvienDTO;

public interface LoaiThanhVienService {
	public void add(LoaithanhvienDTO loaiThanhVienDTO);

	public void update(LoaithanhvienDTO loaiThanhVienDTO);

	public void delete(LoaithanhvienDTO loaiThanhVienDTO);

	public LoaithanhvienDTO getByID(int maLoaiThanhVienDTO);

	public List<LoaithanhvienDTO> getAll();

	public List<LoaithanhvienDTO> searchByName(String tenLoaiThanhVienDTO, int curentPage, int size);
}
