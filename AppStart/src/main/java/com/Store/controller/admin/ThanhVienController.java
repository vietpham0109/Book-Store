package com.Store.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Store.model.ThanhvienDTO;
import com.Store.service.LoaiThanhVienService;
import com.Store.service.ThanhVienService;

@Controller
@RequestMapping(value = "/admin/thanh-vien")
public class ThanhVienController {
	@Autowired
	ThanhVienService thanhVienService;
	@Autowired 
	LoaiThanhVienService loaiThanhVienService;
	
	@GetMapping(value = "danh-sach-thanh-vien")
	public String listUsers(HttpServletRequest req) {
		// get parameters for search
		String tenthanhvien = req.getParameter("tenthanhvien") == null ? "" : req.getParameter("tenthanhvien");
		String tentaikhoan = req.getParameter("tentaikhoan") == null ? "" : req.getParameter("tentaikhoan");
		String loaithanhvien = req.getParameter("loaithanhvien") == null ? "" : req.getParameter("loaithanhvien");

		// information of pagination
		int size = 5;
		int totalData = thanhVienService
				.searchThanhVien(tenthanhvien, loaithanhvien, 0, (int) thanhVienService.count()).size();
		int totalPage = totalData < 1 ? 1
				: totalData / size * size < totalData ? totalData / size + 1 : totalData / size;
		int currentPage = req.getParameter("currentPage") == null ? 1
				: Integer.parseInt(req.getParameter("currentPage"));
		currentPage = currentPage < 1 ? 1 : currentPage > totalPage ? totalPage : currentPage;
		int start = (currentPage - 1) * size + 1;
		int end = start + size - 1 < totalData ? start + size - 1 : totalData;

		// set Attribute
		req.setAttribute("tenthanhvien", tenthanhvien);
		req.setAttribute("tentaikhoan", tentaikhoan);
		req.setAttribute("loaithanhvien", loaithanhvien);

		req.setAttribute("currentPage", currentPage);
		req.setAttribute("totalData", totalData);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("start", start);
		req.setAttribute("end", end);

		req.setAttribute("LoaiThanhViens", loaiThanhVienService.getAll());

		List<ThanhvienDTO> listThanhViens = thanhVienService
				.searchThanhVien(tenthanhvien, loaithanhvien, currentPage - 1, size);

		req.setAttribute("listThanhViens", listThanhViens);
		return "admin/user/listusers";
	}

	@GetMapping(value = "/thong-tin-thanh-vien/{id}")
	public String detailsUser(HttpServletRequest req, @PathVariable(name = "id") int id) {
		req.setAttribute("thanhvien", thanhVienService.getThanhVienById(id));
		String roles = new String();
		for(String role : thanhVienService.getRolesByUsername(thanhVienService.getThanhVienById(id).getTaiKhoan())) {
			roles += role + " "; 
		}
		req.setAttribute("roles", roles);
		return "admin/user/details";
	}

	@GetMapping(value = "/xoa-thanh-vien/{id}")
	public String deleteUser(HttpServletRequest req, @PathVariable(name = "id") int id) {
		thanhVienService.deleteThanhVien(thanhVienService.getThanhVienById(id));
		return "redirect:/admin/thanh-vien/danh-sach-thanh-vien";
	}
}
