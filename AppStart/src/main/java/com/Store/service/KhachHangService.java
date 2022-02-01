package com.Store.service;

import java.util.List;

import com.Store.model.KhachhangDTO;

public interface KhachHangService {
	public void addKhachHang(KhachhangDTO khachhangDTO);

	public void updateKhachHang(KhachhangDTO khachhangDTO);

	public void deleteKhachHang(KhachhangDTO khachhangDTO);

	public KhachhangDTO getKhachHangByID(int maKhachhangDTO);
	
	public KhachhangDTO getKhachHangByName(String tenKhachhangDTO);

	public List<KhachhangDTO> getAllKhachHang(int currentPage, int size);
	
	public List<KhachhangDTO> search(String tenKhachhangDTO, int currentPage, int size);
	
	public KhachhangDTO search(String tenKhachhangDTO, String soDienThoai, String email);
	long count();
}
