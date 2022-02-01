package com.Store.service;

import java.util.List;

import com.Store.model.VaitroDTO;

public interface VaiTroService {
	public void add(VaitroDTO vaiTroDTO);

	public void update(VaitroDTO vaiTroDTO);

	public void delete(VaitroDTO vaiTroDTO);

	public VaitroDTO getByID(int maVaiTroDTO);

	public List<VaitroDTO> getAll();

	public List<VaitroDTO> searchByName(String tenVaiTroDTO, int curentPage, int size);
}
