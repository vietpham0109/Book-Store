package com.Store.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Store.entity.Sach;

public interface SachRepository extends JpaRepository<Sach, Integer> {

	@Query("SELECT s FROM Sach s JOIN s.theloai tl JOIN s.nhaxuatban nxb "
			+ "JOIN s.nhommua nm WHERE (s.tenSach like:tensach AND tl.tenTheLoai like:theloai "
			+ "AND nxb.tenNhaXuatBan like:nxb AND nm.tenNhom like:nhommua " + "AND (s.donGia between :start AND :end))")
	public List<Sach> search(@Param("tensach") String tensach, @Param("theloai") String theloai,
			@Param("nxb") String nxb, @Param("nhommua") String nhommua, @Param("start") long start,
			@Param("end") long end, Pageable page);
}
