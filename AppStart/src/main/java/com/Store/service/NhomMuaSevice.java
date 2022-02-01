package com.Store.service;

import java.util.List;

import com.Store.model.NhommuaDTO;

public interface NhomMuaSevice {
	public void add(NhommuaDTO nhomMuaDTO);

	public void update(NhommuaDTO nhomMuaDTO);

	public void delete(NhommuaDTO nhomMuaDTO);

	public NhommuaDTO getByID(int maNhomMuaDTO);

	public List<NhommuaDTO> getAll();

	public List<NhommuaDTO> searchByName(String tenNhomMuaDTO, int curentPage, int size);
}
