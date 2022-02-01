package com.Store.service;

import java.util.List;

import com.Store.model.TheloaiDTO;

public interface TheLoaiService {
	public void add(TheloaiDTO theLoaiDTO);

	public void update(TheloaiDTO theLoaiDTO);

	public void delete(TheloaiDTO theLoaiDTO);

	public TheloaiDTO getByID(int maTheLoaiDTO);

	public List<TheloaiDTO> getAll();

	public List<TheloaiDTO> searchByName(String tenTheLoaiDTO, int curentPage, int size);
	
	/*
	 * public List<TheloaiDTO> listByNhomMua (String tenNhom);
	 */
	}
