package com.Store.service;

import java.util.List;

import com.Store.model.SachDTO;

public interface SachService {
	public void addBook(SachDTO sachDTO);

	public void updateBook(SachDTO sachDTO);

	public void deleteBook(SachDTO sachDTO);

	public SachDTO getBookById(int maSach);

	public List<SachDTO> getAllBook(int currentPage, int size);
	
	public List<SachDTO> search(String tensach, String theloai, String nxb, String nhommua,
			long start, long end, int currentPage, int size);
	
	long count();
}
