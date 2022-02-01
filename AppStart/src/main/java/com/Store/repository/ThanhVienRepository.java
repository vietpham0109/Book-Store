package com.Store.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Store.entity.Thanhvien;

public interface ThanhVienRepository extends JpaRepository<Thanhvien, Integer> {

	@Query("SELECT tv FROM Thanhvien tv JOIN tv.loaithanhvien ltv "
			+ "WHERE (tv.hoTen like:hoten AND ltv.tenLoaiThanhVien like:loaithanhvien )")
	public List<Thanhvien> search(@Param("hoten") String hoten, @Param("loaithanhvien") String loaithanhvien,
			Pageable page);
	@Query("SELECT tv FROM Thanhvien tv WHERE (tv.taiKhoan = :taikhoan)")
	public Thanhvien getByUsername(@Param("taikhoan") String taikhoan);
}
