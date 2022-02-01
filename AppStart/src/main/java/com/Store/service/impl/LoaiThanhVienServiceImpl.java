package com.Store.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Store.entity.Loaithanhvien;
import com.Store.entity.Vaitro;
import com.Store.model.LoaithanhvienDTO;
import com.Store.model.VaitroDTO;
import com.Store.repository.LoaiThanhVienRepository;
import com.Store.repository.ThanhVienRepository;
import com.Store.service.LoaiThanhVienService;

@Transactional
@Service
public class LoaiThanhVienServiceImpl implements LoaiThanhVienService {

	@Autowired
	private LoaiThanhVienRepository loaiThanhVienReponsitory;
	@Autowired
	ThanhVienRepository thanhVienRepository;
	
	@Override
	public void add(LoaithanhvienDTO loaiThanhVienDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(LoaithanhvienDTO loaiThanhVienDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(LoaithanhvienDTO loaiThanhVienDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public LoaithanhvienDTO getByID(int maLoaiThanhVienDTO) {
		Loaithanhvien loaiThanhVien = loaiThanhVienReponsitory.getById(maLoaiThanhVienDTO);

		LoaithanhvienDTO loaiThanhVienDTO = new LoaithanhvienDTO();

		loaiThanhVienDTO.setMaLoaiThanhVien(loaiThanhVien.getMaLoaiThanhVien());
		loaiThanhVienDTO.setTenLoaiThanhVien(loaiThanhVien.getTenLoaiThanhVien());
		loaiThanhVienDTO.setUuDai(loaiThanhVien.getUuDai());

		List<Vaitro> listVaiTro = loaiThanhVien.getVaitros();
		List<VaitroDTO> listVaiTroDTO = new ArrayList<VaitroDTO>();
		for(Vaitro vaiTro : listVaiTro) {
			VaitroDTO vaiTroDTO = new VaitroDTO();
			vaiTroDTO.setMaVaiTro(vaiTro.getMaVaiTro());
			vaiTroDTO.setTenVaiTro(vaiTro.getTenVaiTro());
			listVaiTroDTO.add(vaiTroDTO);
		}
		loaiThanhVienDTO.setVaiTro(listVaiTroDTO);
		
		return loaiThanhVienDTO;
	}

	@Override
	public List<LoaithanhvienDTO> getAll() {
		List<Loaithanhvien> listLoaiThanhVien = loaiThanhVienReponsitory.findAll();

		List<LoaithanhvienDTO> listLoaiThanhVienDTO = new ArrayList<LoaithanhvienDTO>();

		for (Loaithanhvien loaiThanhVien : listLoaiThanhVien) {

			LoaithanhvienDTO loaiThanhVienDTO = new LoaithanhvienDTO();

			loaiThanhVienDTO.setMaLoaiThanhVien(loaiThanhVien.getMaLoaiThanhVien());
			loaiThanhVienDTO.setTenLoaiThanhVien(loaiThanhVien.getTenLoaiThanhVien());
			loaiThanhVienDTO.setUuDai(loaiThanhVien.getUuDai());
			
			List<Vaitro> listVaiTro = loaiThanhVien.getVaitros();
			List<VaitroDTO> listVaiTroDTO = new ArrayList<VaitroDTO>();
			for(Vaitro vaiTro : listVaiTro) {
				VaitroDTO vaiTroDTO = new VaitroDTO();
				vaiTroDTO.setMaVaiTro(vaiTro.getMaVaiTro());
				vaiTroDTO.setTenVaiTro(vaiTro.getTenVaiTro());
				listVaiTroDTO.add(vaiTroDTO);
			}
			loaiThanhVienDTO.setVaiTro(listVaiTroDTO);
			listLoaiThanhVienDTO.add(loaiThanhVienDTO);
		}
		return listLoaiThanhVienDTO;
	}

	@Override
	public List<LoaithanhvienDTO> searchByName(String tenLoaiThanhVienDTO, int curentPage, int size) {
		return null;
	}

}
