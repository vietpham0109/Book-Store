package com.Store.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Store.model.VaitroDTO;
import com.Store.service.VaiTroService;

@Transactional
@Service
public class VaiTroServiceImpl implements VaiTroService{
	
	@Override
	public void add(VaitroDTO vaiTroDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(VaitroDTO vaiTroDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(VaitroDTO vaiTroDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VaitroDTO getByID(int maVaiTroDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VaitroDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VaitroDTO> searchByName(String tenVaiTroDTO, int curentPage, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
