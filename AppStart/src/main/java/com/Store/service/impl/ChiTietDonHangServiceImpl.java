package com.Store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Store.entity.Chitietdonhang;
import com.Store.entity.Donhang;
import com.Store.entity.Sach;
import com.Store.model.ChitietdonhangDTO;
import com.Store.model.DonhangDTO;
import com.Store.model.SachDTO;
import com.Store.repository.ChiTietDonHangRepository;
import com.Store.service.ChiTietDonHangService;

@Transactional
@Service
public class ChiTietDonHangServiceImpl implements ChiTietDonHangService{
	@Autowired
	ChiTietDonHangRepository chiTietDonHangRepository;
	
	@Override
	public void addCTDH(ChitietdonhangDTO chitietdonhangDTO) {
		Chitietdonhang CTDH = new Chitietdonhang();
		CTDH.setDonGia(chitietdonhangDTO.getDonGia());
		CTDH.setMaChiTietDDH(chitietdonhangDTO.getMaChiTietDDH());
		CTDH.setSoLuong(chitietdonhangDTO.getSoLuong());
		CTDH.setTenSach(chitietdonhangDTO.getTenSach());
		
		SachDTO sachDTO = chitietdonhangDTO.getSach();
		Sach sach = new Sach();
		sach.setMaSach(sachDTO.getMaSach());
		CTDH.setSach(sach);
		
		DonhangDTO donhangDTO = chitietdonhangDTO.getDonHang();
		Donhang donhang = new Donhang();
		donhang.setMaDonHang(donhangDTO.getMaDonHang());
		CTDH.setDonhang(donhang);
		
		chiTietDonHangRepository.save(CTDH);
	}

	@Override
	public void updateDTDH(ChitietdonhangDTO chitietdonhangDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCTDH(ChitietdonhangDTO chitietdonhangDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ChitietdonhangDTO getCTDHByID(int maChitietdonhangDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChitietdonhangDTO> getAllCTDH(int currentPage, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChitietdonhangDTO> search(DonhangDTO donHang, int currentPage, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
