package com.Store.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.Store.model.DonhangDTO;

public interface DonHangService {
	public void addDonHang(DonhangDTO donhangDTO);

	public void updateDonHang(DonhangDTO donhangDTO);

	public void deleteDonHang(DonhangDTO donhangDTO);

	public DonhangDTO getDonHangByID(int maDonhangDTO);

	public List<DonhangDTO> getAllDonHang(int currentPage, int size);

	public List<DonhangDTO> search(String tenkhachhang, String tringtrang, String ngaydat, int currentPage, int size) throws ParseException;

	public DonhangDTO getLastDonHang();
	
	long count();
}
