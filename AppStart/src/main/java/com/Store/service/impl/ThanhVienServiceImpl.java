package com.Store.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Store.entity.Loaithanhvien;
import com.Store.entity.Thanhvien;
import com.Store.entity.Vaitro;
import com.Store.model.LoaithanhvienDTO;
import com.Store.model.ThanhvienDTO;
import com.Store.model.VaitroDTO;
import com.Store.repository.ThanhVienRepository;
import com.Store.service.ThanhVienService;

@Transactional
@Service
public class ThanhVienServiceImpl implements ThanhVienService {

	@Autowired
	private ThanhVienRepository thanhVienRepository;

	@Override
	public void addThanhVien(ThanhvienDTO thanhVienDTO) {
		Thanhvien thanhVien = new Thanhvien();
		thanhVien.setMaThanhVien(thanhVienDTO.getMaThanhVien());
		thanhVien.setHoTen(thanhVienDTO.getHoTen());
		thanhVien.setEmail(thanhVienDTO.getEmail());
		thanhVien.setDiaChi(thanhVienDTO.getDiaChi());
		thanhVien.setSoDienThoai(thanhVienDTO.getSoDienThoai());
		thanhVien.setTaiKhoan(thanhVienDTO.getTaiKhoan());
		
		//can encode mat khau voi thu vien giong security de thong nhat , ma hoa mat khau
		thanhVien.setMatKhau(new BCryptPasswordEncoder(12).encode(thanhVienDTO.getMatKhau()));

		Loaithanhvien loaiThanhVien = new Loaithanhvien();
		loaiThanhVien.setMaLoaiThanhVien(thanhVienDTO.getLoaiThanhVien().getMaLoaiThanhVien());

		thanhVien.setLoaithanhvien(loaiThanhVien);

		thanhVienRepository.save(thanhVien);
	}

	@Override
	public void updateThanhVien(ThanhvienDTO thanhVienDTO) {
		Thanhvien thanhVien = thanhVienRepository.getById(thanhVienDTO.getMaThanhVien());

		thanhVien.setMaThanhVien(thanhVienDTO.getMaThanhVien());
		thanhVien.setHoTen(thanhVienDTO.getHoTen());
		thanhVien.setEmail(thanhVienDTO.getEmail());
		thanhVien.setDiaChi(thanhVienDTO.getDiaChi());
		thanhVien.setSoDienThoai(thanhVienDTO.getSoDienThoai());
		thanhVien.setTaiKhoan(thanhVienDTO.getTaiKhoan());
		thanhVien.setMatKhau(new BCryptPasswordEncoder(12).encode(thanhVienDTO.getMatKhau()));

		Loaithanhvien loaiThanhVien = new Loaithanhvien();
		loaiThanhVien.setMaLoaiThanhVien(thanhVienDTO.getLoaiThanhVien().getMaLoaiThanhVien());

		thanhVien.setLoaithanhvien(loaiThanhVien);

		thanhVienRepository.save(thanhVien);
	}

	@Override
	public void deleteThanhVien(ThanhvienDTO thanhVienDTO) {
		thanhVienRepository.deleteById(thanhVienDTO.getMaThanhVien());
	}

	@Override
	public ThanhvienDTO getThanhVienById(int maThanhVien) {
		Thanhvien thanhVien = thanhVienRepository.getById(maThanhVien);

		ThanhvienDTO thanhVienDTO = new ThanhvienDTO();

		thanhVienDTO.setMaThanhVien(thanhVien.getMaThanhVien());
		thanhVienDTO.setHoTen(thanhVien.getHoTen());
		thanhVienDTO.setEmail(thanhVien.getEmail());
		thanhVienDTO.setDiaChi(thanhVien.getDiaChi());
		thanhVienDTO.setSoDienThoai(thanhVien.getSoDienThoai());
		thanhVienDTO.setTaiKhoan(thanhVien.getTaiKhoan());
		thanhVienDTO.setMatKhau(thanhVien.getMatKhau());

		LoaithanhvienDTO loaiThanhVienDTO = new LoaithanhvienDTO();
		loaiThanhVienDTO.setMaLoaiThanhVien(thanhVien.getLoaithanhvien().getMaLoaiThanhVien());
		loaiThanhVienDTO.setTenLoaiThanhVien(thanhVien.getLoaithanhvien().getTenLoaiThanhVien());
		loaiThanhVienDTO.setUuDai(thanhVien.getLoaithanhvien().getUuDai());
		
		List<Vaitro> listVaiTro = thanhVien.getLoaithanhvien().getVaitros();
		List<VaitroDTO> listVaiTroDTO = new ArrayList<VaitroDTO>();
		for(Vaitro vaiTro : listVaiTro) {
			VaitroDTO vaiTroDTO = new VaitroDTO();
			vaiTroDTO.setMaVaiTro(vaiTro.getMaVaiTro());
			vaiTroDTO.setTenVaiTro(vaiTro.getTenVaiTro());
			listVaiTroDTO.add(vaiTroDTO);
		}
		loaiThanhVienDTO.setVaiTro(listVaiTroDTO);
		
		thanhVienDTO.setLoaiThanhVien(loaiThanhVienDTO);

		return thanhVienDTO;
	}

	@Override
	public List<ThanhvienDTO> getAllThanhVien(int currentPage, int size) {
		List<ThanhvienDTO> listThanhVienDTO = new ArrayList<ThanhvienDTO>();
		List<Thanhvien> listThanhVien = thanhVienRepository
				.findAll(PageRequest.of(currentPage, size, Sort.by("maThanhVien"))).toList();

		for (Thanhvien thanhVien : listThanhVien) {
			ThanhvienDTO thanhVienDTO = new ThanhvienDTO();

			thanhVienDTO.setMaThanhVien(thanhVien.getMaThanhVien());
			thanhVienDTO.setHoTen(thanhVien.getHoTen());
			thanhVienDTO.setEmail(thanhVien.getEmail());
			thanhVienDTO.setDiaChi(thanhVien.getDiaChi());
			thanhVienDTO.setSoDienThoai(thanhVien.getSoDienThoai());
			thanhVienDTO.setTaiKhoan(thanhVien.getTaiKhoan());
			thanhVienDTO.setMatKhau(thanhVien.getMatKhau());

			LoaithanhvienDTO loaiThanhVienDTO = new LoaithanhvienDTO();
			loaiThanhVienDTO.setMaLoaiThanhVien(thanhVien.getLoaithanhvien().getMaLoaiThanhVien());
			loaiThanhVienDTO.setTenLoaiThanhVien(thanhVien.getLoaithanhvien().getTenLoaiThanhVien());
			loaiThanhVienDTO.setUuDai(thanhVien.getLoaithanhvien().getUuDai());

			List<Vaitro> listVaiTro = thanhVien.getLoaithanhvien().getVaitros();
			List<VaitroDTO> listVaiTroDTO = new ArrayList<VaitroDTO>();
			for(Vaitro vaiTro : listVaiTro) {
				VaitroDTO vaiTroDTO = new VaitroDTO();
				vaiTroDTO.setMaVaiTro(vaiTro.getMaVaiTro());
				vaiTroDTO.setTenVaiTro(vaiTro.getTenVaiTro());
				listVaiTroDTO.add(vaiTroDTO);
			}
			loaiThanhVienDTO.setVaiTro(listVaiTroDTO);
			
			thanhVienDTO.setLoaiThanhVien(loaiThanhVienDTO);

			listThanhVienDTO.add(thanhVienDTO);
		}
		return listThanhVienDTO;
	}

	@Override
	public List<ThanhvienDTO> searchThanhVien(String tenThanhVien, String loaiThanhVien, int currentPage, int size) {
		List<ThanhvienDTO> listThanhVienDTO = new ArrayList<ThanhvienDTO>();
		PageRequest page = PageRequest.of(currentPage, size);
		
		List<Thanhvien> listThanhVien = thanhVienRepository.search("%" + tenThanhVien + "%", "%" + loaiThanhVien + "%",
				page);
		for (Thanhvien thanhVien : listThanhVien) {
			ThanhvienDTO thanhVienDTO = new ThanhvienDTO();

			thanhVienDTO.setMaThanhVien(thanhVien.getMaThanhVien());
			thanhVienDTO.setHoTen(thanhVien.getHoTen());
			thanhVienDTO.setEmail(thanhVien.getEmail());
			thanhVienDTO.setDiaChi(thanhVien.getDiaChi());
			thanhVienDTO.setSoDienThoai(thanhVien.getSoDienThoai());
			thanhVienDTO.setTaiKhoan(thanhVien.getTaiKhoan());
			thanhVienDTO.setMatKhau(thanhVien.getMatKhau());

			LoaithanhvienDTO loaiThanhVienDTO = new LoaithanhvienDTO();
			loaiThanhVienDTO.setMaLoaiThanhVien(thanhVien.getLoaithanhvien().getMaLoaiThanhVien());
			loaiThanhVienDTO.setTenLoaiThanhVien(thanhVien.getLoaithanhvien().getTenLoaiThanhVien());
			loaiThanhVienDTO.setUuDai(thanhVien.getLoaithanhvien().getUuDai());

			List<Vaitro> listVaiTro = thanhVien.getLoaithanhvien().getVaitros();
			List<VaitroDTO> listVaiTroDTO = new ArrayList<VaitroDTO>();
			for(Vaitro vaiTro : listVaiTro) {
				VaitroDTO vaiTroDTO = new VaitroDTO();
				vaiTroDTO.setMaVaiTro(vaiTro.getMaVaiTro());
				vaiTroDTO.setTenVaiTro(vaiTro.getTenVaiTro());
				listVaiTroDTO.add(vaiTroDTO);
			}
			loaiThanhVienDTO.setVaiTro(listVaiTroDTO);
			
			thanhVienDTO.setLoaiThanhVien(loaiThanhVienDTO);

			listThanhVienDTO.add(thanhVienDTO);
		}
		return listThanhVienDTO;
	}

	@Override
	public long count() {
		return thanhVienRepository.count();
	}

	@Override
	public List<String> getRolesByUsername(String usename) {
		List<String> roles = new ArrayList<String>();
		Thanhvien thanhvien = thanhVienRepository.getByUsername(usename);
		for(Vaitro vaiTro : thanhvien.getLoaithanhvien().getVaitros()) {
			roles.add(vaiTro.getTenVaiTro());
		}
		return roles;
	}

	@Override
	public ThanhvienDTO getThanhVienByUsername(String username) {
		Thanhvien thanhVien = thanhVienRepository.getByUsername(username);
		ThanhvienDTO thanhVienDTO = new ThanhvienDTO();

		thanhVienDTO.setMaThanhVien(thanhVien.getMaThanhVien());
		thanhVienDTO.setHoTen(thanhVien.getHoTen());
		thanhVienDTO.setEmail(thanhVien.getEmail());
		thanhVienDTO.setDiaChi(thanhVien.getDiaChi());
		thanhVienDTO.setSoDienThoai(thanhVien.getSoDienThoai());
		thanhVienDTO.setTaiKhoan(thanhVien.getTaiKhoan());
		thanhVienDTO.setMatKhau(thanhVien.getMatKhau());

		LoaithanhvienDTO loaiThanhVienDTO = new LoaithanhvienDTO();
		loaiThanhVienDTO.setMaLoaiThanhVien(thanhVien.getLoaithanhvien().getMaLoaiThanhVien());
		loaiThanhVienDTO.setTenLoaiThanhVien(thanhVien.getLoaithanhvien().getTenLoaiThanhVien());
		loaiThanhVienDTO.setUuDai(thanhVien.getLoaithanhvien().getUuDai());

		List<Vaitro> listVaiTro = thanhVien.getLoaithanhvien().getVaitros();
		List<VaitroDTO> listVaiTroDTO = new ArrayList<VaitroDTO>();
		for(Vaitro vaiTro : listVaiTro) {
			VaitroDTO vaiTroDTO = new VaitroDTO();
			vaiTroDTO.setMaVaiTro(vaiTro.getMaVaiTro());
			vaiTroDTO.setTenVaiTro(vaiTro.getTenVaiTro());
			listVaiTroDTO.add(vaiTroDTO);
		}
		loaiThanhVienDTO.setVaiTro(listVaiTroDTO);
		
		thanhVienDTO.setLoaiThanhVien(loaiThanhVienDTO);
		
		return thanhVienDTO;
	}

}
