package com.Store.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Store.entity.Nhommua;
import com.Store.model.NhommuaDTO;
import com.Store.repository.NhomMuaRepository;
import com.Store.service.NhomMuaSevice;

@Transactional
@Service
public class NhomMuaServiceImpl implements NhomMuaSevice {

	@Autowired
	private NhomMuaRepository nhomMuaRepository;

	@Override
	public void add(NhommuaDTO nhomMuaDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(NhommuaDTO nhomMuaDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(NhommuaDTO nhomMuaDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public NhommuaDTO getByID(int maNhomMuaDTO) {
		Nhommua nhomMua = nhomMuaRepository.getById(maNhomMuaDTO);

		NhommuaDTO nhommuaDTO = new NhommuaDTO();

		nhommuaDTO.setMaNhom(nhomMua.getMaNhom());
		nhommuaDTO.setTenNhom(nhomMua.getTenNhom());

		return nhommuaDTO;
	}

	@Override
	public List<NhommuaDTO> getAll() {
		List<NhommuaDTO> listNhomMuaDTO = new ArrayList<NhommuaDTO>();
		
		List<Nhommua> listNhomMua = nhomMuaRepository.findAll();
		for(Nhommua nhomMua : listNhomMua) {
			NhommuaDTO nhommuaDTO = new NhommuaDTO();
			
			nhommuaDTO.setMaNhom(nhomMua.getMaNhom());
			nhommuaDTO.setTenNhom(nhomMua.getTenNhom());
			
			listNhomMuaDTO.add(nhommuaDTO);		
		}
		
		return listNhomMuaDTO;
	}

	@Override
	public List<NhommuaDTO> searchByName(String tenNhomMuaDTO, int curentPage, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
