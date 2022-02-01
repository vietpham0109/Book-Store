package com.Store.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Store.entity.Theloai;
import com.Store.model.TheloaiDTO;
import com.Store.repository.TheLoaiRepository;
import com.Store.service.TheLoaiService;

@Transactional
@Service
public class TheLoaiServiceImpl implements TheLoaiService{
	
	@Autowired
	private TheLoaiRepository theLoaiRepository;

	@Override
	public void add(TheloaiDTO theLoaiDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TheloaiDTO theLoaiDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TheloaiDTO theLoaiDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TheloaiDTO getByID(int maTheLoaiDTO) {
		Theloai theloai = theLoaiRepository.getById(maTheLoaiDTO);

		TheloaiDTO theloaiDTO = new TheloaiDTO();

		theloaiDTO.setMaTheLoai(theloai.getMaTheLoai());
		theloaiDTO.setTenTheLoai(theloai.getTenTheLoai());
		theloaiDTO.setIcon(theloai.getIcon());

		return theloaiDTO;
	}

	@Override
	public List<TheloaiDTO> getAll() {
		List<TheloaiDTO> listTheloaiDTOs = new ArrayList<TheloaiDTO>();
		List<Theloai> listTheloais = theLoaiRepository.findAll();
		
		for(Theloai theloai : listTheloais) {
			TheloaiDTO theloaiDTO = new TheloaiDTO();

			theloaiDTO.setMaTheLoai(theloai.getMaTheLoai());
			theloaiDTO.setTenTheLoai(theloai.getTenTheLoai());
			theloaiDTO.setIcon(theloai.getIcon());
			
			listTheloaiDTOs.add(theloaiDTO);
		}
		
		return listTheloaiDTOs;
	}

	@Override
	public List<TheloaiDTO> searchByName(String tenTheLoaiDTO, int curentPage, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public List<TheloaiDTO> listByNhomMua(String tenNhom) {
	 * List<Theloai> listTheloais = theLoaiRepository.getByNhomMua(tenNhom);
	 * List<TheloaiDTO> listTheloaiDTOs = new ArrayList<TheloaiDTO>(); for(Theloai
	 * theloai : listTheloais) { TheloaiDTO theloaiDTO = new TheloaiDTO();
	 * 
	 * theloaiDTO.setMaTheLoai(theloai.getMaTheLoai());
	 * theloaiDTO.setTenTheLoai(theloai.getTenTheLoai());
	 * theloaiDTO.setIcon(theloai.getIcon());
	 * 
	 * listTheloaiDTOs.add(theloaiDTO); }
	 * 
	 * return listTheloaiDTOs; }
	 */

}
