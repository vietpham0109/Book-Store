package com.Store.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Store.entity.Nhaxuatban;
import com.Store.model.NhaxuatbanDTO;
import com.Store.repository.NhaXuatBanRepository;
import com.Store.service.NhaXuatBanService;

@Transactional
@Service
public class NhaXuatBanServiceImpl implements NhaXuatBanService{
	
	@Autowired
	private NhaXuatBanRepository nhaXuatBanRepository;

	@Override
	public void add(NhaxuatbanDTO nhaXuatBanDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(NhaxuatbanDTO nhaXuatBanDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(NhaxuatbanDTO nhaXuatBanDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NhaxuatbanDTO getByID(int maNhaXuatBanDTO) {
		Nhaxuatban nhaXuatBan = nhaXuatBanRepository.getById(maNhaXuatBanDTO);
		
		NhaxuatbanDTO nhaxuatbanDTO = new  NhaxuatbanDTO();
		
		nhaxuatbanDTO.setMaNhaXuatBan(nhaXuatBan.getMaNhaXuatBan());
		nhaxuatbanDTO.setTenNhaXuatBan(nhaXuatBan.getTenNhaXuatBan());
		nhaxuatbanDTO.setThongTin(nhaXuatBan.getThongTin());
		nhaxuatbanDTO.setLogo(nhaXuatBan.getLogo());
		return nhaxuatbanDTO;
	}

	@Override
	public List<NhaxuatbanDTO> getAll() {
		List<Nhaxuatban> listNhaXuatBan = nhaXuatBanRepository.findAll();
		
		List<NhaxuatbanDTO> listNhaxuatbanDTO = new  ArrayList<NhaxuatbanDTO>();
		
		for(Nhaxuatban nhaXuatBan : listNhaXuatBan) {
			
		NhaxuatbanDTO nhaxuatbanDTO = new NhaxuatbanDTO();
		
		nhaxuatbanDTO.setMaNhaXuatBan(nhaXuatBan.getMaNhaXuatBan());
		nhaxuatbanDTO.setTenNhaXuatBan(nhaXuatBan.getTenNhaXuatBan());
		nhaxuatbanDTO.setThongTin(nhaXuatBan.getThongTin());
		nhaxuatbanDTO.setLogo(nhaXuatBan.getLogo());
		
		listNhaxuatbanDTO.add(nhaxuatbanDTO);
		}
		return listNhaxuatbanDTO;
	}

	@Override
	public List<NhaxuatbanDTO> searchByName(String tenNhaXuatBanDTO, int curentPage, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
