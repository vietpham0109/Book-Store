package com.Store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Store.entity.Khachhang;

public interface KhachHangRepository extends JpaRepository<Khachhang, Integer> {

	@Query("SELECT kh FROM Khachhang kh WHERE (kh.tenKhachHang = :tenkhachhang)")
	public Khachhang getByName(@Param("tenkhachhang") String tenkhachhang);

	@Query("SELECT kh FROM Khachhang kh WHERE (kh.tenKhachHang = :tenkhachhang AND kh.email = :email AND kh.soDienThoai = :sodienthoai)")
	public Khachhang search(@Param("tenkhachhang") String tenkhachhang, @Param("email") String email,
			@Param("sodienthoai") String sodienthoai);
}
