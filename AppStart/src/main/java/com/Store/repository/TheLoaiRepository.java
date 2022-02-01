package com.Store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Store.entity.Theloai;

public interface TheLoaiRepository extends JpaRepository<Theloai, Integer>{
	/*
	 * @Query("SELECT tl FROM s. tl JOIN tl.saches s JOIN s.nhommua nm WHERE (nm.tenNhom = :tennhom "
	 * + "AND nm.saches = tl.saches)") public List<Theloai>
	 * getByNhomMua(@Param("tennhom") String tennhom);
	 */
}
