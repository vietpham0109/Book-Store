package com.Store.service;

import java.util.List;

import com.Store.model.ChitietdonhangDTO;
import com.Store.model.DonhangDTO;

public interface ChiTietDonHangService {
	public void addCTDH(ChitietdonhangDTO chitietdonhangDTO);

	public void updateDTDH(ChitietdonhangDTO chitietdonhangDTO);

	public void deleteCTDH(ChitietdonhangDTO chitietdonhangDTO);

	public ChitietdonhangDTO getCTDHByID(int maChitietdonhangDTO);

	public List<ChitietdonhangDTO> getAllCTDH(int currentPage, int size);
	
	public List<ChitietdonhangDTO> search(DonhangDTO donHang, int currentPage, int size);
	
	long count();
}
