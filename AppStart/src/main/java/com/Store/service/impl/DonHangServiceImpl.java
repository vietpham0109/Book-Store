package com.Store.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Store.entity.Chitietdonhang;
import com.Store.entity.Donhang;
import com.Store.entity.Khachhang;
import com.Store.entity.Thanhvien;
import com.Store.model.ChitietdonhangDTO;
import com.Store.model.DonhangDTO;
import com.Store.model.KhachhangDTO;
import com.Store.model.ThanhvienDTO;
import com.Store.repository.ChiTietDonHangRepository;
import com.Store.repository.DonHangRepository;
import com.Store.repository.KhachHangRepository;
import com.Store.service.DonHangService;

@Transactional
@Service
public class DonHangServiceImpl implements DonHangService {
	@Autowired
	DonHangRepository donHangRepository;
	@Autowired
	KhachHangRepository khachHangRepository;
	@Autowired
	ChiTietDonHangRepository chiTietDonHangRepository;

	@Override
	public void addDonHang(DonhangDTO donhangDTO) {
		Donhang donhang = new Donhang();

		donhang.setMaDonHang(donhangDTO.getMaDonHang());
		donhang.setNgayDat(donhangDTO.getNgayDat());
		donhang.setNgayGiao(donhangDTO.getNgayGiao());
		donhang.setDaThanhToan(donhangDTO.getDaThanhToan());
		donhang.setTinhTrangGiaoHang(donhangDTO.getTinhTrangGiaoHang());
		donhang.setUuDai(donhangDTO.getUuDai());

		/*
		 * List<ChitietdonhangDTO> listCTDHDTO = donhangDTO.getChiTietDonHang();
		 * List<Chitietdonhang> listCTDH = new ArrayList<Chitietdonhang>();
		 * for(ChitietdonhangDTO CTDHDTO : listCTDHDTO) { // có cần chi tiết không ?,
		 * chi tiết tạo sau đơn hàng Chitietdonhang CTDH =
		 * chiTietDonHangRepository.getById(CTDHDTO.getMaChiTietDDH());
		 * listCTDH.add(CTDH); } donhang.setChiTietDonHangs(listCTDH);
		 */

		KhachhangDTO khachHangDTO = donhangDTO.getKhachHang();
		Khachhang khachHang = khachHangRepository.getById(khachHangDTO.getMaKhachHang());
		donhang.setKhachhang(khachHang);

		donHangRepository.save(donhang);
	}

	@Override
	public void updateDonHang(DonhangDTO donhangDTO) {
		// khách hàng -> đơn hàng -> chi tiết <- sách
		// người dùng được sửa ngày đặt, chi tiết
		// admin được sửa tình trạng, thanh toán, ngày giao

	}

	@Override
	public void deleteDonHang(DonhangDTO donhangDTO) {
		donHangRepository.deleteById(donhangDTO.getMaDonHang());
	}

	@Override
	public DonhangDTO getDonHangByID(int maDonhangDTO) {
		Donhang donHang = donHangRepository.getById(maDonhangDTO);
		DonhangDTO donHangDTO = new DonhangDTO();

		donHangDTO.setDaThanhToan(donHang.getDaThanhToan());
		donHangDTO.setMaDonHang(donHang.getMaDonHang());
		donHangDTO.setNgayDat(donHang.getNgayDat());
		donHangDTO.setNgayGiao(donHang.getNgayGiao());
		donHangDTO.setTinhTrangGiaoHang(donHang.getTinhTrangGiaoHang());
		donHangDTO.setUuDai(donHang.getUuDai());

		KhachhangDTO khachHangDTO = new KhachhangDTO();
		Khachhang khachHang = donHang.getKhachhang();
		khachHangDTO.setMaKhachHang(khachHang.getMaKhachHang());
		khachHangDTO.setTenKhachHang(khachHang.getTenKhachHang());
		khachHangDTO.setDiaChi(khachHang.getDiaChi());
		khachHangDTO.setEmail(khachHang.getEmail());
		khachHangDTO.setSoDienThoai(khachHang.getSoDienThoai());

		if (khachHang.getThanhvien() != null) {
			Thanhvien thanhVien = khachHang.getThanhvien();
			ThanhvienDTO thanhVienDTO = new ThanhvienDTO();
			thanhVienDTO.setMaThanhVien(thanhVien.getMaThanhVien());

			khachHangDTO.setThanhVien(thanhVienDTO);
		}

		donHangDTO.setKhachHang(khachHangDTO);

		if (donHang.getChiTietDonHangs() != null) {
			List<Chitietdonhang> listChiTietDonHang = donHang.getChiTietDonHangs();
			List<ChitietdonhangDTO> listChiTietDonHangDTO = new ArrayList<ChitietdonhangDTO>();
			for (Chitietdonhang CTDH : listChiTietDonHang) {
				ChitietdonhangDTO CTDHDTO = new ChitietdonhangDTO();
				CTDHDTO.setDonGia(CTDH.getDonGia());
				CTDHDTO.setMaChiTietDDH(CTDH.getMaChiTietDDH());
				CTDHDTO.setSoLuong(CTDH.getSoLuong());
				CTDHDTO.setTenSach(CTDH.getTenSach());

				listChiTietDonHangDTO.add(CTDHDTO);
			}

			donHangDTO.setChiTietDonHang(listChiTietDonHangDTO);
		}
		return donHangDTO;
	}

	@Override
	public List<DonhangDTO> getAllDonHang(int currentPage, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		return donHangRepository.count();
	}

	@Override
	public List<DonhangDTO> search(String tenkhachhang, String tringtrang, String ngaydat, int currentPage, int size)
			throws ParseException {
		List<DonhangDTO> listDonHangDTO = new ArrayList<DonhangDTO>();
		List<Donhang> listDonHang = donHangRepository.search("%" + tenkhachhang + "%", "%" + tringtrang + "%",
				new SimpleDateFormat("yyyy-MM-dd").parse(ngaydat),
				PageRequest.of(currentPage, size, Sort.by("maDonHang")));

		for (Donhang donHang : listDonHang) {
			DonhangDTO donHangDTO = new DonhangDTO();

			donHangDTO.setDaThanhToan(donHang.getDaThanhToan());
			donHangDTO.setMaDonHang(donHang.getMaDonHang());
			donHangDTO.setNgayDat(donHang.getNgayDat());
			donHangDTO.setNgayGiao(donHang.getNgayGiao());
			donHangDTO.setTinhTrangGiaoHang(donHang.getTinhTrangGiaoHang());
			donHangDTO.setUuDai(donHang.getUuDai());

			KhachhangDTO khachHangDTO = new KhachhangDTO();
			Khachhang khachHang = donHang.getKhachhang();
			khachHangDTO.setMaKhachHang(khachHang.getMaKhachHang());
			khachHangDTO.setTenKhachHang(khachHang.getTenKhachHang());
			khachHangDTO.setDiaChi(khachHang.getDiaChi());
			khachHangDTO.setEmail(khachHang.getEmail());
			khachHangDTO.setSoDienThoai(khachHang.getSoDienThoai());

			donHangDTO.setKhachHang(khachHangDTO);

			List<Chitietdonhang> listChiTietDonHang = donHang.getChiTietDonHangs();
			List<ChitietdonhangDTO> listChiTietDonHangDTO = new ArrayList<ChitietdonhangDTO>();
			for (Chitietdonhang CTDH : listChiTietDonHang) {
				ChitietdonhangDTO CTDHDTO = new ChitietdonhangDTO();
				CTDHDTO.setDonGia(CTDH.getDonGia());
				CTDHDTO.setMaChiTietDDH(CTDH.getMaChiTietDDH());
				CTDHDTO.setSoLuong(CTDH.getSoLuong());
				CTDHDTO.setTenSach(CTDH.getTenSach());

				listChiTietDonHangDTO.add(CTDHDTO);
			}

			donHangDTO.setChiTietDonHang(listChiTietDonHangDTO);
			listDonHangDTO.add(donHangDTO);
		}

		return listDonHangDTO;
	}

	@Override
	public DonhangDTO getLastDonHang() {
		List<Donhang> listDonHang = donHangRepository.findAll(Sort.by("maDonHang").descending());
		Donhang donHang = listDonHang.get(0);
		DonhangDTO donHangDTO = new DonhangDTO();

		donHangDTO.setDaThanhToan(donHang.getDaThanhToan());
		donHangDTO.setMaDonHang(donHang.getMaDonHang());
		donHangDTO.setNgayDat(donHang.getNgayDat());
		donHangDTO.setNgayGiao(donHang.getNgayGiao());
		donHangDTO.setTinhTrangGiaoHang(donHang.getTinhTrangGiaoHang());
		donHangDTO.setUuDai(donHang.getUuDai());

		return donHangDTO;
	}

}
