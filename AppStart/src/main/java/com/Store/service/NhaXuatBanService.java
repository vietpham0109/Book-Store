package com.Store.service;

import java.util.List;

import com.Store.model.NhaxuatbanDTO;

public interface NhaXuatBanService {
	public void add(NhaxuatbanDTO nhaXuatBanDTO);

	public void update(NhaxuatbanDTO nhaXuatBanDTO);

	public void delete(NhaxuatbanDTO nhaXuatBanDTO);

	public NhaxuatbanDTO getByID(int maNhaXuatBanDTO);

	public List<NhaxuatbanDTO> getAll();

	public List<NhaxuatbanDTO> searchByName(String tenNhaXuatBanDTO, int curentPage, int size);
}
